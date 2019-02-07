package tecktalk201902.groovy

import org.junit.Before

import jp.co.gxp.tecktalk201902.jo.JoService
import jp.co.gxp.tecktalk201902.jo.PersonRepository
import jp.co.gxp.tecktalk201902.jo.entity.Story
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll
import tecktalk201902.testcase.Test_Chapter2

/* ================================================================================
 * ((1)) spock.lang.Specification を 継承
 * ================================================================================*/
class Groovy_Test_Chapter2 extends Specification implements CharactersSupport, Test_Chapter2 {

	private JoService sut

/* ================================================================================
 * ((2)). Junitいらない, ただし、＠Before相当はsetupという名前であること
 ================================================================================ */
//	@Before
	public void setup() {
		// テスト対象の初期化
		sut = new JoService()

/* ================================================================================
 * ((3)) spockframework built in mocking.
 ================================================================================ */
		PersonRepository personRepository = Mock(PersonRepository) {
			characters(_) >> { Integer storyNumber ->
				return mockCharacters(storyNumber)
			}
		}

/* ================================================================================
 * ((4)) groovyはprivateにアクセス可能(非推奨っぽいけど)
 * ================================================================================*/
		sut.personRepository = personRepository
	}

//	@Override
	@Ignore("interfaceを実装しているため、spockframeworkがclosureに変換できないのでテスト実行できない")
	public void テスト２＿parameterizedテスト() {
	}

/*================================================================================
 * ((5)) Patametertized & Unrollテスト
 ================================================================================*/
	@Unroll
	def '第 #storyNumber 部の主人公は #nameExpected である'(Integer storyNumber, String nameExpected) {

		when:
		Story actual = sut.story(storyNumber)

		then:
		1 == actual.characters.size() // "登場人物は一人であること",
		nameExpected == actual.characters[0].name // "jojoの名前は${name}であること",

		where:
		storyNumber || nameExpected
		// --------------------
		1           || "ジョナサン・ジョースター"
		2           || "ジョセフ・ジョースター"
		3           || "空条承太郎"
		4           || "東方仗助"
		5           || "ジョルノ・ジョバーナ"
	}
}
