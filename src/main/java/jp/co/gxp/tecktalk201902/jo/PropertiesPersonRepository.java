package jp.co.gxp.tecktalk201902.jo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.co.gxp.tecktalk201902.jo.entity.Jo;
import jp.co.gxp.tecktalk201902.jo.entity.Person;

public class PropertiesPersonRepository implements PersonRepository {

	private final Map<Integer, List<Jo>> data;

	public PropertiesPersonRepository(Map<Integer, List<Jo>> data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see jp.co.gxp.tecktalk201902.jo.PersonRepository#find(java.lang.String)
	 */
	@Override
	public Jo find(String name) {
		return new Jo();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see jp.co.gxp.tecktalk201902.jo.PersonRepository#find(java.lang.Integer)
	 */
	@Override
	public Set<Person> characters(Integer storyNumber) {
		List<Jo> list = data.getOrDefault(storyNumber, new ArrayList<>());
		return new HashSet<>(list);
	}
}
