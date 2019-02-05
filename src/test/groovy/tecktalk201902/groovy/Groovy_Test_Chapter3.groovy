package tecktalk201902.groovy;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.gxp.tecktalk201902.Tecktalk201902Application;
import jp.co.gxp.tecktalk201902.jo.JoController;
import tecktalk201902.testcase.Test_Chapter3;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Tecktalk201902Application.class })
@ActiveProfiles("production")
public class Junit4_Test_Chapter3 implements Test_Chapter3 {

	/** spring test */
	private MockMvc mockMvc;

	/** テスト対象controller */
	@Autowired
	private JoController sut;

	@Before
	public void setup() {
		// spring test setup.
		mockMvc = MockMvcBuilders.standaloneSetup(sut).build();

		// TODO: repositoryのmock化.
	}

	/* (non-Javadoc)
	 * @see tecktalk201902.junit4.Test_Chapter3#テスト３＿springbootのテスト()
	 */
	@Override
	@Test
	public void テスト３＿springbootのテスト() throws Exception {

		// "/jo/stories" というurlにリクエストした結果を確認する.
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/jo/stories"))
				.andExpect(jsonPath("$[2].number", is(3))) // json-pathによる結果のjsonのテスト.
				.andExpect(jsonPath("$[2].title", is("Stardust Crusaders"))) //
				.andExpect(jsonPath("$[2].characters[0].name", is("空条承太郎")))

				.andReturn();

		System.out.println(result.getResponse().getContentAsString());

	}
}
