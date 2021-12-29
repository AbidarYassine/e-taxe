package com.example.gatewayservice.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GatewayConfig {


    private final RouteDefinitionLocator locator;
    private final AuthenticationFilter filter;

    public GatewayConfig(RouteDefinitionLocator locator, AuthenticationFilter filter) {
        this.locator = locator;
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("taxe-sejour", r -> r.path("/taxe-sejour/v1/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://TAXE-SEJOUR"))
                .route("auth-service", r -> r.path("/users/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://AUTH-SERVICE"))
                .route("local-service", r -> r.path("/api/local/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://LOCAL-SERVICE"))
                .build();
    }

    @Bean
    public List<GroupedOpenApi> apis() {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        assert definitions != null;
        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
            String name = routeDefinition.getId().replaceAll("-service", "");
            groups.add(GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build());
        });
        return groups;
    }
}
