package tecktalk201902.jo;

import java.util.HashSet;
import java.util.Set;

import jp.co.gxp.tecktalk201902.jo.PersonRepository;
import jp.co.gxp.tecktalk201902.jo.entity.Jo;
import jp.co.gxp.tecktalk201902.jo.entity.Person;

/**
 * PersonRepositoryのテスト用モック実装.
 *
 * @author y.takada
 *
 */
public class MockPersonRepository implements PersonRepository {

	/*
	 * (non-Javadoc)
	 *
	 * @see jp.co.gxp.tecktalk201902.jo.PersonRepository#find(java.lang.String)
	 */
	@Override
	public Jo find(String name) {
		Jo jo = new Jo();
		jo.setName("空条承太郎");
		jo.setQuote("つけの領収書だぜ");
		jo.setStand("スタープラチナ");
		return jo;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see jp.co.gxp.tecktalk201902.jo.PersonRepository#find(java.lang.Integer)
	 */
	@Override
	public Set<Person> characters(Integer storyNumber) {

		HashSet<Person> result = new HashSet<>();

		Jo jo = new Jo();

		switch (storyNumber) {
		case 1:
			jo.setName("ジョナサン・ジョースター");
			jo.setQuote("震えるぞハート！燃え尽きるほどヒート！！");
			break;
		case 2:
			jo.setName("ジョセフ・ジョースター");
			jo.setQuote("");
			break;
		case 3:
			jo.setName("空条承太郎");
			jo.setQuote("つけの領収書だぜ");
			jo.setStand("スタープラチナ");
			break;
		case 4:
			jo.setName("東方仗助");
			jo.setQuote("あんた今なんつった！");
			jo.setStand("クレイジーダイヤモンド");
			break;
		case 5:
			jo.setName("ジョルノ・ジョバーナ");
			jo.setQuote("アリーヴェデルチ");
			jo.setStand("ゴールドエクスペリエンス");
			break;
		}
		result.add(jo);
		return result;
	}
}
