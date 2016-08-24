package info.dgsoft.restful.integration.config;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import info.dgsoft.restful.integration.util.TestApiConfig;

@Configuration
public class TestContext {

  @Bean
  public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
    factory.setPort(TestApiConfig.PORT);
    factory.setSessionTimeout(10, TimeUnit.MINUTES);
    System.out.println("java.io.tmpdir" + System.getProperty("java.io.tmpdir"));
    return factory;
  }

}
