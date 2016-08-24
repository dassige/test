package info.dgsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application
{

	public static void main(String[] args)
	{
		SpringApplication springApplication = new SpringApplication(Application.class);

		springApplication.addListeners(new ApplicationPidFileWriter());
		springApplication.run(args);
	}

	@Bean
	public Docket newsApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).groupName("DGSoft Services")
				.apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title("DGSoft.info REST services documentation").description("")
				.termsOfServiceUrl("http://www.dgsoft.info/rest/services/terms")
				.contact("Gerardo Dassi").license("Apache License Version 2.0").version("2.0")
				.build();
	}
}
