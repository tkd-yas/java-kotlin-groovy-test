package jp.co.gxp.tecktalk201902;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import jp.co.gxp.tecktalk201902.jo.PersonRepository;
import jp.co.gxp.tecktalk201902.jo.StaticPersonRepository;

@Profile({ "develop", "!production" })
@Configuration
public class DevelopJoConfig {

	@Bean
	public PersonRepository personRepository() {
		return new StaticPersonRepository();
	}
}