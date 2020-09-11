package com.wyj.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 自定义filter
 * @author wyj
 *
 */
@Configuration
public class CustomGlobalFilter implements GlobalFilter,Ordered{

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return -1;//返回-1代表最新执行的filter
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		//获取用户名
		if(exchange.getRequest().getQueryParams().get("username")!=null) {
			System.out.println("ok");
			//用户名不为空放行
			return chain.filter(exchange);
		}
		System.out.println("error");
		//返回
		return exchange.getResponse().setComplete();
	}

}
