package tecktalk201902.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.spring.SpringListener
import jp.co.gxp.tecktalk201902.Tecktalk201902Application
import jp.co.gxp.tecktalk201902.jo.JoController
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders

//@RunWith(SpringRunner::class)
@SpringJUnitConfig
@SpringBootTest(classes = arrayOf(Tecktalk201902Application::class))
@ActiveProfiles("production")
@ContextConfiguration(classes = [(Tecktalk201902Application::class)])
class Kotlin_Test_Chapter3 : StringSpec() {

    override fun listeners() = listOf(SpringListener)

    /** spring test */
    @Autowired
    var sut: JoController? = null

    init {
        val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(sut).build()

        "テスト３＿springbootのテスト" {
            val result = mockMvc.perform(MockMvcRequestBuilders.get("/jo/stories"))
//			.andExpect(jsonPath("$[2].number", `is`(3))) // json-pathによる結果のjsonのテスト.
//			.andExpect(jsonPath("$[2].title", `is`("Stardust Crusaders"))) //
//			.andExpect(jsonPath("$[2].characters[0].name", `is`("空条承太郎")))
                    .andReturn()

            val stories = JSONObject(result.response.contentAsString)
            val story3 = stories.optJSONArray(null).getJSONObject(2)
            story3.getInt("number") shouldBe 3
            story3.getString("title") shouldBe "Stardust Crusaders"
            story3.getJSONArray("characters").getJSONObject(0).getString("name") shouldBe "空条承太郎"
        }
    }
}