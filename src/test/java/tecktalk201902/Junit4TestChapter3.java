package tecktalk201902;

import static org.hamcrest.Matchers.is;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.gxp.tecktalk201902.Tecktalk201902Application;
import jp.co.gxp.tecktalk201902.jo.JoController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Tecktalk201902Application.class })
@ActiveProfiles("production")
public class Junit4TestChapter3 {

	private MockMvc mockMvc;

	@Autowired
	private JoController sut;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(sut).build();
	}

	@Test
	public void テスト３＿springbootのテスト() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/jo/stories"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].number", is(3)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].title", is("Stardust Crusaders")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].characters[0].name", is("空条承太郎")))

				.andReturn();

		System.out.println(result.getResponse().getContentAsString());

	}
}
