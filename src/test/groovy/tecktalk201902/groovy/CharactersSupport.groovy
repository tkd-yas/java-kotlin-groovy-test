package tecktalk201902.groovy

import jp.co.gxp.tecktalk201902.jo.entity.Person
import jp.co.gxp.tecktalk201902.jo.entity.Jo

/**
 *
 * <a href="http://docs.groovy-lang.org/next/html/documentation/core-traits.html">groovy trait.</a><br>
 *
 * 実装をもったinterface.<br>
 * javaのデフォルトメソッドができたおかげでそんなに使いどころない感があるが、
 * 実装クラスのフィールドやメソッドにアクセスできる点が便利.
 * @author y.takada
 *
 */
public trait CharactersSupport {

	private static final String[] NAMES = [
	                  "スティーリー・ダン"
	                  ,"ジョナサン・ジョースター"
	                  ,"ジョセフ・ジョースター"
	                  ,"空条承太郎"
	                  ,"東方仗助"
	                  ,"ジョルノ・ジョバーナ"
	                  ,'空条徐倫',
	                  , 'ジョニィ・ジョースター'
	                  , '東方定助'
	                  ]

	public Set<Person> mockCharacters(Integer storyNumber) {
		return [new Jo(name: NAMES[storyNumber])].toSet()
	}
}
