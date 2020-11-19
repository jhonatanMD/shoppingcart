package com.api.carrito.ws;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket customerSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(
                    RequestHandlerSelectors
                    .basePackage("com.api.carrito.ws.controller"))
            .paths(regex("/api.*"))
            .build().apiInfo(metaData());
		
		
	}
	
    private ApiInfo metaData() {

        ApiInfo apiInfo = new ApiInfo(

                "Spring Boot REST API",

                "Spring Boot REST API CARRITO DE VENTAS",

                "1.0",

                "WEB SERVICES",

                new Contact("Jhonatan Mallqui", "---", "jhonatanmd1999@gmail.com"),

               "Apache License Version 2.0",

                "https://www.apache.org/licenses/LICENSE-2.0");

        return apiInfo;

    }
}
