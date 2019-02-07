package tecktalk201902.groovy

import static org.hamcrest.Matchers.is
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.util.StopWatch

import jp.co.gxp.tecktalk201902.Tecktalk201902Application
import jp.co.gxp.tecktalk201902.jo.JoController
import spock.lang.Specification

@SpringBootTest(classes = Tecktalk201902Application)
/* ================================================================================
 * ((1)) spock.lang.Specification を 継承
 * ================================================================================*/
public class Groovy_Test_Chapter3 extends Specification {

	/** spring test */
	private MockMvc mockMvc;

	@Autowired
	private JoController sut

	private static StopWatch stopWatch

	def setupSpec() {
		stopWatch = new StopWatch()
		stopWatch.start('spockframework - spring-boot test')
	}

	def cleanupSpec() {
		stopWatch.stop()

		println "================================================================================"
		println stopWatch.prettyPrint()
		println "================================================================================"

	}

/* ================================================================================
 * ((2)). Junitいらない, ただし、＠Before相当はsetupという名前であること
 ================================================================================ */
//	@Before
	public void setup() {
		// spring test setup.
		mockMvc = MockMvcBuilders.standaloneSetup(sut).build()
	}

//	@Override
//	@Test
	public void テスト３＿springbootのテスト() throws Exception {

		when:
/* ================================================================================
 * ((3)) json pathではなくデシリアライズしてアサーションが簡単.
 ================================================================================ */
		// "/jo/stories" というurlにリクエストした結果を確認する.
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/jo/stories"))
//				.andExpect(jsonPath('$[2].number', is(3))) // json-pathによる結果のjsonのテスト.
//				.andExpect(jsonPath('$[2].title', is("Stardust Crusaders"))) //
//				.andExpect(jsonPath('$[2].characters[0].name', is("空条承太郎")))

				.andReturn();

		def jsonSlurper = new JsonSlurper()
		def actual = jsonSlurper.parseText(result.response.contentAsString)
		def story3 = actual[2]

	then:
/* ================================================================================
 * ((3)) json pathではなくデシリアライズしてアサーションが簡単.
 ================================================================================ */
		println actual
		story3.number == 3
		story3.title == 'Stardust Crusaders'
		story3.characters[0].name == '空条承太郎'

	}
}
