package jp.co.gxp.tecktalk201902;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jp.co.gxp.tecktalk201902.jo.PersonRepository;
import jp.co.gxp.tecktalk201902.jo.PropertiesPersonRepository;
import jp.co.gxp.tecktalk201902.jo.entity.Jo;

@Profile({ "production" })
@Component
@Configuration
@PropertySource(value = { "classpath:/jo.properties" }, encoding = "utf-8")
public class ProductionJoConfig {

	@Autowired
	private JoConfig joConfig;

	private static Jo create(String line) {
		String[] cols = line.split(",");
		Jo jo = new Jo();
		jo.setStoryNumber(Integer.valueOf(cols[0]));
		jo.setName(cols[1]);
		jo.setQuote(cols.length > 2 ? cols[2] : null);
		jo.setStand(cols.length > 3 ? cols[3] : null);
		return jo;
	}

	@Bean
	public PersonRepository personRepository() {
		return new PropertiesPersonRepository(data());
	}

	public Map<Integer, List<Jo>> data() {
		return getCharacters().stream().map(ProductionJoConfig::create)
				.collect(Collectors.groupingBy(Jo::getStoryNumber));
	}

	public List<String> getCharacters() {
		return joConfig.getCharacters();
	}

}
