package jp.co.gxp.tecktalk201902.jo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.gxp.tecktalk201902.jo.entity.Person;
import jp.co.gxp.tecktalk201902.jo.entity.Story;

@Service
public class JoService {

	@Autowired
	private PersonRepository personRepository;

	public Story story(Integer number) {
		Set<Person> charcters = personRepository.characters(number);
		return new Story(number, charcters);
	}

}