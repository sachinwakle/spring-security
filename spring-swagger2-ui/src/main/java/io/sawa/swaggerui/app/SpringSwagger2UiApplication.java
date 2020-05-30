package io.sawa.swaggerui.app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringSwagger2UiApplication {
    public static void main(String[] args) {
	SpringApplication.run(SpringSwagger2UiApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
	return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors.basePackage("io.sawa.swaggerui.app")).paths(PathSelectors.ant("/api/*"))
		.build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
	return new ApiInfo("Address Book API", "Provide the complete address book directory", "1.0", "Open Source",
		new springfox.documentation.service.Contact("Sachin Wakle", "https://github.com/sachinwakle",
			"sbwakle@hotmail.com"),
		"API License", "https://github.com/sachinwakle", Collections.emptyList());
    }
}
