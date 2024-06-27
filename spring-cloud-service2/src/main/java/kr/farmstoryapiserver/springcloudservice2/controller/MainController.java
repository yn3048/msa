package kr.farmstoryapiserver.springcloudservice2.controller;

import brave.Span;
import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {

    private final WebClient webClient;
    private final Tracer tracer;

    @GetMapping(value = {"/", "/index"})
    public Mono<String> index(){

        log.info("service2 index...1");
        return webClient
                .get()
                .uri("/index")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping(value ="/user")
    public Mono<String> user(){

        log.info("service2 index...1");
        return webClient
                .get()
                .uri("/user")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/sleuth")
    public String sleuth(){

        Span currentSpan = tracer.currentSpan();

        String traceId = currentSpan.context().traceIdString();
        String spanId = currentSpan.context().spanIdString();

        return "[traceId :" + traceId + ", spanId : " + spanId + "]";
    }

}








