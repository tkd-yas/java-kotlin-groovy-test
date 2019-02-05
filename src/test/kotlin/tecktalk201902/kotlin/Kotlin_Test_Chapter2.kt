package tecktalk201902.kotlin

import java.util.Arrays
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Parameterized.Parameters
import org.springframework.test.util.ReflectionTestUtils
import jp.co.gxp.tecktalk201902.jo.JoService
import jp.co.gxp.tecktalk201902.jo.entity.Story
import tecktalk201902.jo.MockPersonRepository
import tecktalk201902.testcase.Test_Chapter2

/**
 * Tecktalk 2019 02 後半.<br>
 * テストケース２のJunit4実装 パラメタライズドテスト.
 *
 * @author y.takada
 *
 */
@RunWith(Parameterized::class)
class Kotlin_Test_Chapter2 : Test_Chapter2 {
	/** パラメータ１：第N部 */
	@Parameter(0)
	var storyNumber: Integer? = null
	/** パラメータ２：サブタイトル */
	@Parameter(1)
	var name: String? = null
	/** テスト対象 */
	private val sut: JoService? = null

	@Before
	fun setup() {
// テスト対象の初期化
		sut = JoService()
// モック実装をリフレクションを使ってフィールドに設定.
		ReflectionTestUtils.setField(sut, "personRepository", MockPersonRepository())
	}

	/* (non-Javadoc)
         * @see tecktalk201902.junit4.Test_Chapter2#テスト２＿parameterizedテスト()
         */
	@Override
	@Test
	fun テスト２＿parameterizedテスト()
	{
		val actual = sut!!.story(this.storyNumber)
		Assert.assertEquals("登場人物は一人であること", 1, actual!!.getCharacters().size())
		Assert.assertEquals(
			"jojoの名前は" + this.name + "であること", this.name,
			actual!!.getCharacters().iterator().next().getName()
		)
	}

	companion object {
		/**
		 * パラメータ設定. キモい.
		 *
		 * @return
		 */
		//
//
//
//
//
		val parameters: Iterable<Array<Object>>?
			@Parameters(name = "第{0}部のjojoは{1}である.")
			get() {
				return Arrays.asList(
					arrayOf<Array<Object>>(
						arrayOf<Object>(1, "ジョナサン・ジョースター"),
						arrayOf<Object>(2, "ジョセフ・ジョースター"),
						arrayOf<Object>(3, "空条承太郎"),
						arrayOf<Object>(4, "東方仗助"),
						arrayOf<Object>(5, "ジョルノ・ジョバーナ")
					)
				)
			}
	}
}