package com.example.reactivetraining;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class ReactiveTraining {

    public static Mono<String> mapper(String name) {
        return Mono.just(name);
    }

    public static Flux<String> fluxMapper(String name) {
        return Flux.just(name);
    }

    public static Flux<String> explorerOnError() {
        return Flux.just("A", "B", "C");
    }

    public static Flux<String> namesMonoMapFilter(int stringLength) {
        return Mono.just("test")
                .filter(str -> str.length() == stringLength)
                .map(String::toUpperCase)
                .flatMapMany(ReactiveTraining::fluxMapper)
                .defaultIfEmpty("Mono is empty");
    }

    public static Mono<String> namesMonoMapFilterSwitchIfEmpty(int stringLength) {
        return Mono.just("test")
                .filter(str -> str.length() == stringLength)
                .map(String::toUpperCase)
                .switchIfEmpty(Mono.just("Mono is empty, so here's another Mono"));
    }

    public static Flux<String> monoConcatWith() {
        Mono<String> mono1 = Mono.just("String1");
        return Mono.just("String2")
                .concatWith(mono1);
    }

    public static Mono<String> monoZipWith() {
        Mono<String> mono1 = Mono.just("String1");
        return Mono.just("String2")
                .zipWith(mono1)
                .map(s -> s.getT1() + s.getT2());
    }

    public static Flux<String> fluxOnErrorReturn() {
        return Flux.just("hello", "good day")
                .concatWith(Flux.error(new RuntimeException()))
                .onErrorReturn("Error here");
    }

    public static Flux<String> fluxDoOnError() {
        return Flux.just("hello", "good day")
                .map(s -> s.split("", 34)[8])
                .onErrorMap(ex -> {
                    System.out.println(ex);
                    return new FluxException(ex, ex.getMessage());
                });
    }

    public static Mono<String> exceptionMonoOnErrorContinue(String input) {
        return Mono.just(input)
                .map(s -> {
                    if(s.equals("abc"))
                        throw new RuntimeException("Input cannot be " + input);
                    return input;
                })
                .onErrorContinue(
                        (ex, o) -> System.out.println("Exception: " + ex.toString()))
                .log();
    }
}
