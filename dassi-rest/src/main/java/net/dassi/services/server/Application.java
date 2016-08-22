package net.dassi.services.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = { "net.dassi" })
@EnableSwagger2
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);

        springApplication.addListeners(new ApplicationPidFileWriter());
		ApplicationContext context = springApplication.run(args);
		//System.out.println(( (Client) context.getBean("restClient")).getAllEmployees());
	}
	
	@Bean
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }
	
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Dassi Services")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Dassi.net REST services documentation")
				.description("")
				.termsOfServiceUrl("http://www.dassi.net/rest/services/terms")
				.contact("Gerardo Dassi").license("Apache License Version 2.0")
				.version("2.0")
				.build();
	}
}
