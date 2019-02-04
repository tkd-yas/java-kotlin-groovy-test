package tecktalk201902;

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
import jp.co.gxp.tecktalk201902.jo.StaticPersonRepository;
import jp.co.gxp.tecktalk201902.jo.entity.Story;

@RunWith(Parameterized.class)
public class Junit4TestChapter2 {

	@Parameter(0)
	public Integer storyNumber;

	@Parameter(1)
	public String name;

	private JoService sut;

	@Before
	public void setup() {
		sut = new JoService();
		ReflectionTestUtils.setField(sut, "personRepository", new StaticPersonRepository());
	}

	@Test
	public void テスト２＿parameterizedテスト() {

		Story actual = sut.story(this.storyNumber);

		Assert.assertNotNull("結果がnullではないこと", actual);
		Assert.assertEquals("登場人物は一人であること", 1, actual.getCharacters().size());
		Assert.assertEquals("jojoの名前は" + this.name + "であること", this.name,
				actual.getCharacters().iterator().next().getName());
	}

	@Parameters(name = "第{0}部のjojoは{1}である.")
	public static Iterable<Object[]> getParameters() {
		return Arrays.asList(new Object[][] { //
				{ 1, "ジョナサン・ジョースター" }, //
				{ 2, "ジョセフ・ジョースター" }, //
				{ 3, "空条承太郎" }, //
				{ 4, "東方仗助" }, //
				{ 5, "ジョルノ・ジョバーナ" } });
	}
}
