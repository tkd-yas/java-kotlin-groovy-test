package tecktalk201902.junit5;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.test.util.ReflectionTestUtils;

import jp.co.gxp.tecktalk201902.jo.JoService;
import jp.co.gxp.tecktalk201902.jo.entity.Story;
import tecktalk201902.jo.MockPersonRepository;
import tecktalk201902.testcase.Test_Chapter2;

/**
 * Tecktalk 2019 02 後半.<br>
 * テストケース２のJunit5実装 パラメタライズドテスト.
 *
 * @author y.takada
 *
 */
@RunWith(Parameterized.class)
public class Junit5_Test_Chapter2 implements Test_Chapter2 {

	/** パラメータ１：第N部 */
	@Parameter(0)
	public Integer storyNumber;

	/** パラメータ２：サブタイトル */
	@Parameter(1)
	public String name;

	/** テスト対象 */
	private JoService sut;

	/**
	 * パラメータ設定. キモい.
	 * 
	 * @return
	 */
	@Parameters(name = "第{0}部のjojoは{1}である.")
	public static Iterable<Object[]> getParameters() {
		return Arrays.asList(new Object[][] { //
				{ 1, "ジョナサン・ジョースター" }, //
				{ 2, "ジョセフ・ジョースター" }, //
				{ 3, "空条承太郎" }, //
				{ 4, "東方仗助" }, //
				{ 5, "ジョルノ・ジョバーナ" } });
	}

	@Before
	public void setup() {
		// テスト対象の初期化
		sut = new JoService();
		// モック実装をリフレクションを使ってフィールドに設定.
		ReflectionTestUtils.setField(sut, "personRepository", new MockPersonRepository());
	}

	/* (non-Javadoc)
	 * @see tecktalk201902.junit4.Test_Chapter2#テスト２＿parameterizedテスト()
	 */
	@Override
	@Test
	public void テスト２＿parameterizedテスト() {

		Story actual = sut.story(this.storyNumber);

		Assert.assertEquals("登場人物は一人であること", 1, actual.getCharacters().size());
		Assert.assertEquals("jojoの名前は" + this.name + "であること", this.name,
				actual.getCharacters().iterator().next().getName());
	}
}
