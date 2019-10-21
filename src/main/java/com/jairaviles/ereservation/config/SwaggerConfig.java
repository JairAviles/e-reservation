package com.jairaviles.ereservation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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
                    .select()
                    .apis(RequestHandlerSelectors
                            .withClassAnnotation(RestController.class))
                    .paths(PathSelectors.any())
                    .build();
    }
}