package tecktalk201902.kotlin

import org.hamcrest.Matchers.`is`
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import jp.co.gxp.tecktalk201902.Tecktalk201902Application
import jp.co.gxp.tecktalk201902.jo.JoController
import tecktalk201902.testcase.Test_Chapter3

@RunWith(SpringRunner::class)
@SpringBootTest(classes = { Tecktalk201902Application.class })
@ActiveProfiles("production")
class Kotlin_Test_Chapter3 : Test_Chapter3 {
	/** spring test */
	private val mockMvc: MockMvc? = null
	/** テスト対象controller */
	@Autowired
	private val sut: JoController? = null

	@Before
	fun setup() {
// spring test setup.
		mockMvc = MockMvcBuilders.standaloneSetup(sut).build()
// TODO: repositoryのmock化.
	}

	/* (non-Javadoc)
         * @see tecktalk201902.junit4.Test_Chapter3#テスト３＿springbootのテスト()
         */
	@Override
	@Test
	@Throws(Exception::class)
	fun テスト３＿springbootのテスト()
	{
// "/jo/stories" というurlにリクエストした結果を確認する.
		val result = mockMvc!!.perform(MockMvcRequestBuilders.get("/jo/stories"))
			.andExpect(jsonPath("$[2].number", `is`(3))) // json-pathによる結果のjsonのテスト.
			.andExpect(jsonPath("$[2].title", `is`("Stardust Crusaders"))) //
			.andExpect(jsonPath("$[2].characters[0].name", `is`("空条承太郎")))
			.andReturn()
		System.out.println(result!!.getResponse().getContentAsString())
	}
}