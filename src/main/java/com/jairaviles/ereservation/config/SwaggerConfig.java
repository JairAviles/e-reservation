package com.jairaviles.ereservation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Config Class for  Swagger
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors
                            .withClassAnnotation(RestController.class))
                    .paths(PathSelectors.any())
                    .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Reservations Api")
                .description("REST Api for Reservations ")
                .version("1.0.0")
                .license("MIT License")
                .licenseUrl("https://choosealicense.com/licenses/mit/")
                .contact(new Contact("Jair Israel Aviles Eusebio", "http://jairaviles.mx", "hi@jairaviles.mx"))
                .build();
    }
}
