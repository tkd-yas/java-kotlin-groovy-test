package tecktalk201902.junit5;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.gxp.tecktalk201902.Tecktalk201902Application;
import jp.co.gxp.tecktalk201902.jo.JoController;
import tecktalk201902.testcase.Test_Chapter3;

/**
 * Tecktalk 2019 02 後半.<br>
 * テストケース２のJunit5 実装 springbootテスト.
 *
 * @author y.takada
 *
 */
/* ================================================================================
 * ((1)) アノテーションいらないをjunit5のものにかえる
 * import org.junit.Before;                          => import org.junit.jupiter.api.BeforeEach;
 * import org.junit.Test;                            => import org.junit.jupiter.api.Test;
 * import org.junit.runner.RunWith => org.springframework.test.context.junit.jupiter.SpringJUnitConfig ※ > spring 5
 * ================================================================================*/
//@RunWith(SpringRunner.class)
@SpringJUnitConfig
@SpringBootTest(classes = { Tecktalk201902Application.class })
@ActiveProfiles("production")
public class Junit5_Test_Chapter3 implements Test_Chapter3 {

	/** spring test */
	private MockMvc mockMvc;

	/** テスト対象controller */
	@Autowired
	private JoController sut;

	@BeforeEach
	public void setup() {
		// spring test setup.
		mockMvc = MockMvcBuilders.standaloneSetup(sut).build();
	}

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
