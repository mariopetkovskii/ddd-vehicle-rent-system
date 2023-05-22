package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/rest/vehicle/**")
                        .and()
                        .uri("lb://vehicle-list-service"))
                .route(r -> r.path("/rest/user/**")
                        .and()
                        .uri("lb://users-service"))
                .route(r -> r.path("/rest/rent/**")
                        .and()
                        .uri("lb://rent-management-service"))
                .build();
    }
}