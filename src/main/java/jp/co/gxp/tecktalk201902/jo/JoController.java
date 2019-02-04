package jp.co.gxp.tecktalk201902.jo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.gxp.tecktalk201902.jo.entity.Story;
import jp.co.gxp.tecktalk201902.jo.entity.Story.Title;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class JoController {

	@Autowired
	private JoService joService;

	@RequestMapping("/jo/{jo}")
	@ResponseBody
	public String init(@PathVariable Integer jo) {
		switch (jo) {
		case 1:
			return "震えるぞハート！燃え尽きるほどヒート!!";
		case 2:
			return "確実！そうコーラを飲んだらゲップが出るっていうくらい確実じゃッ！";
		case 3:
			return repeat("オラ", 255);
		case 4:
			return "おい...先輩 あんた...今おれのこの頭のことなんつった！";
		case 5:
			return "この味は....ウソをついている「味」だぜ...";
		case 6:
			return "落ち着け...素数を数えて落ち着くんだ...2..3..5..7..11..";
		case 7:
			return "いともたやすく行われるえげつない行為";
		case 8:
			return "(データがありません)";

		default:
			return repeat("ムダ", 255);
		}
	}

	@RequestMapping("/jo/stories")
	@ResponseBody
	public List<Story> stories() {
		Title[] titles = Story.Title.values();
		List<Story> stories = Stream.of(titles).map(t -> joService.story(t.getStoryNumber()))
				.collect(Collectors.toList());
		log.info("jojo stories :{}", stories);

		return stories;
	}

	private static String repeat(String val, int times) {
		String[] arr = new String[times];
		Arrays.fill(arr, val);
		return String.join("", arr);
	}
}