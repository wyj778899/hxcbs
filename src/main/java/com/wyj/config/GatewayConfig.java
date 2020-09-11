package com.wyj.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基于代码的网关配置
 * @author wyj
 *
 */
@Configuration
public class GatewayConfig {

	
//	@Bean
//	public RouteLocator customRouRouteLocator(RouteLocatorBuilder builder) {
//		
//		/**
//		 * 一个网关配置对应一个route
//		 */
//		return builder.routes()
//			   .route("user_route",r->r.path("/user/**").uri("http://localhost:9999")).build();
//	}
}
