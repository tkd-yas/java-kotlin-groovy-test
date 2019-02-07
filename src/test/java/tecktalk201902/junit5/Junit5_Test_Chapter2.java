package tecktalk201902.junit5;

import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
/* ================================================================================
 * ((1)) アノテーションいらないをjunit5のものにかえる
 * import org.junit.Assert;                          => import static org.junit.jupiter.api.Assertions.*;
 * import org.junit.Before;                          => import org.junit.jupiter.api.BeforeEach;
 * import org.junit.Test;                            => import org.junit.jupiter.api.Test;
 * ================================================================================*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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
/*================================================================================
 * ((1)) org.junit.runners.RunWith;いらない.
 ================================================================================*/
//@RunWith(Parameterized.class)
public class Junit5_Test_Chapter2 implements Test_Chapter2 {

/*================================================================================
 * ((2)) org.junit.runners.Parameterized.Parameter;いらない.フィールドもいらない.
 ================================================================================*/
//	/** パラメータ１：第N部 */
//	@Parameter(0)
//	public Integer storyNumber;

//	/** パラメータ２：サブタイトル */
//	@Parameter(1)
//	public String name;

	/** テスト対象 */
	private JoService sut;

	/**
	 * パラメータ設定. まだキモい.
	 *
	 * @return
	 */
	/*================================================================================
	 * ((3)) org.junit.jupiter.params.provider.ArgumentsのStreamを返す
	 ================================================================================*/
	public static Stream<Arguments> getParameters() {
		return Stream.of(
				Arguments.of( 1, "ジョナサン・ジョースター" ), //
				Arguments.of( 2, "ジョセフ・ジョースター" ), //
				Arguments.of( 3, "空条承太郎" ), //
				Arguments.of( 4, "東方仗助" ), //
				Arguments.of( 5, "ジョルノ・ジョバーナ" ));
	}

	@BeforeEach
	public void setup() {
		// TEST対象の初期化
		sut = new JoService();
		// TEST実装をリフレクションを使ってフィールドに設定.
		ReflectionTestUtils.setField(sut, "personRepository", new MockPersonRepository());
	}
	@Override
	@Ignore("引数にパラメータをとるので実装できない...")
	public void テスト２＿parameterizedテスト() {

	}
	/*================================================================================
	 * ((4)) org.junit.Testいらない
	 * 以下のアノテーションでパラメータテスト
	 * org.junit.jupiter.params.ParameterizedTest;
	 * org.junit.jupiter.params.provider.MethodSource;
	 ================================================================================*/
//	@Test
	@ParameterizedTest(name = "第{0}部のjojoは{1}である.")
	@MethodSource("getParameters")
	public void テスト２＿parameterizedテスト(Integer storyNumber, String name) {

		Story actual = sut.story(storyNumber);
/*================================================================================
 * ((5)) org.junit.jupiter.api.Assertionsではmessageは最後の引数になった
 ================================================================================*/
		Assertions.assertEquals(1, actual.getCharacters().size(), "登場人物は一人であること");
		Assertions.assertEquals(name,
				actual.getCharacters().iterator().next().getName(),"jojoの名前は" + name + "であること");
	}
}
