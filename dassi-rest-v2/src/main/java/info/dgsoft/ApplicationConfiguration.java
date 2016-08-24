package info.dgsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration
{

	@Autowired
	Environment env;

	@Bean
	public String getInfo()
	{
		// return info = env.getProperty("application.info");
		return "bleahh";
	}
}
