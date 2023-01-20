package com.example.gateway.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {
    public LoggingFilter() {
        super(Config.class);
    }

    @Data
    public static class Config {
        // configuration 정보
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }

    @Override
    public GatewayFilter apply(Config config) {
        // custom pre filter
//        return ((exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//            ServerHttpResponse response = exchange.getResponse();
//
//            log.info("Global Filter baseMessage = {}", config.getBaseMessage());
//
//            if (config.isPreLogger()) {
//                log.info("Global Filter Start: request id -> {}", config.getBaseMessage());
//            }
//
//            // Custom Post Filter
//
//            return chain.filter(exchange).then(Mono.fromRunnable(
//
//                    () -> {
//                        if (config.isPostLogger()) {
//                            log.info("Global Filter End: request id -> {}", config.getBaseMessage());
//                        }
//                    }));
//        });


        GatewayFilter filter = new OrderedGatewayFilter( (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Logging Filter baseMessage = {}", config.getBaseMessage());

            if (config.isPreLogger()) {
                log.info("Logging Filter Start: request id -> {}", config.getBaseMessage());
            }

            // Custom Post Filter

            return chain.filter(exchange).then(Mono.fromRunnable(

                    () -> {
                        if (config.isPostLogger()) {
                            log.info("Logging Filter End: request id -> {}", config.getBaseMessage());
                        }
                    }));
        }, Ordered.HIGHEST_PRECEDENCE);

        return filter;
    }
}
