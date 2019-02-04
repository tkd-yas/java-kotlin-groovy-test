package jp.co.gxp.tecktalk201902.jo;

import java.util.Set;

import org.springframework.stereotype.Repository;

import jp.co.gxp.tecktalk201902.jo.entity.Jo;
import jp.co.gxp.tecktalk201902.jo.entity.Person;

@Repository
public interface PersonRepository {

	Jo find(String name);

	Set<Person> characters(Integer storyNumber);

}