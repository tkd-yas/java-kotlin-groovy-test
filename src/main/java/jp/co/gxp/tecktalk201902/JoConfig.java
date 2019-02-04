package jp.co.gxp.tecktalk201902;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("jo")
@Getter
@Setter
public class JoConfig {

	private List<String> characters;

}