package me.suongnguyen.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r
//					.path("/api/employees/**")
//					.uri("lb://EMPLOYEE-SERVICE")
//				)
//				.route(r -> r
//					.path("/api/departments/**")
//					.uri("lb://DEPARTMENT-SERVICE")
//				)
//				.build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
