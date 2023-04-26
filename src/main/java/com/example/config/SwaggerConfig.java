package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    private ApiKey apiKey() {
        return new ApiKey("osaAPIKey", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("osaAPIKey", authorizationScopes));
    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(apiKey()))
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("zcoa.service.sync.controller"))
//                .paths(PathSelectors.regex("/api/.*"))
//                .build();
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "Ops Sync App API",
//                "Ops Sync App API",
//                "1.0",
//                "Terms of service",
//                new Contact("Dasvision", "www.dasvision.vn", "tridv@dasvision.vn"),
//                "License of API",
//                "API license URL",
//                Collections.emptyList());
//    }

}
