package com.netec.app.filters;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class EjemploFiltro implements GlobalFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(EjemploFiltro.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		LOGGER.info("Ejecutando el Filtro PRE {}, {} ", exchange, chain);

		exchange.getRequest().mutate().headers(x -> x.add("token", "****1234"));

		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			LOGGER.info("Ejecutando el Filtro POST");
			exchange.getResponse().getCookies().add("nombre", ResponseCookie.from("nombre", "Netec_Cookie").build());
			exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
			Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token")).ifPresent(token -> {
				exchange.getResponse().getHeaders().add("token", token);
			});
		}));
	}

}
