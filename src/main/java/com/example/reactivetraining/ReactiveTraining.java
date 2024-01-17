package com.example.reactivetraining;

import reactor.core.publisher.Mono;

import java.util.Locale;

public class ReactiveTraining {

    public static Mono<String> namesMonoMapFilter(int stringLength) {
        return Mono.just("test")
                .filter(str -> str.length() == stringLength)
                .map(String::toUpperCase)
                .defaultIfEmpty("Mono is empty");
    }

    public static Mono<String> namesMonoMapFilterSwitchIfEmpty(int stringLength) {
        return Mono.just("test")
                .filter(str -> str.length() == stringLength)
                .map(String::toUpperCase)
                .switchIfEmpty(Mono.just("Mono is empty, so here's another Mono"));
    }
}
