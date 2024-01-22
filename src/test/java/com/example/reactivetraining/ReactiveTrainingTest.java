package com.example.reactivetraining;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class ReactiveTrainingTest {

    @Test
    public void namesMonoMapFilterSuccess() {
        StepVerifier.create(ReactiveTraining.namesMonoMapFilter(4))
                .expectNext("TEST")
                .verifyComplete();
    }

    @Test
    public void namesMonoMapFilterDefaultIfEmptyTest() {
        StepVerifier.create(ReactiveTraining.namesMonoMapFilter(3))
                .expectNext("Mono is empty")
                .verifyComplete();
    }

    @Test
    public void namesMonoMapFilterSwitchIfEmptyTest() {
        StepVerifier.create(ReactiveTraining.namesMonoMapFilterSwitchIfEmpty(3))
                .expectNext("Mono is empty, so here's another Mono")
                .verifyComplete();
    }

    @Test
    void fluxOnErrorReturn() {
        StepVerifier.create(ReactiveTraining.fluxOnErrorReturn())
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void fluxDoOnError() {
        StepVerifier.create(ReactiveTraining.fluxDoOnError())
                .expectError(FluxException.class)
                .verify();
    }

    @Test
    void exceptionMonoOnErrorContinueError() {
        StepVerifier.create(ReactiveTraining.exceptionMonoOnErrorContinue("abc"))
                .verifyComplete();
    }

    @Test
    void exceptionMonoOnErrorContinueSuccess() {
        StepVerifier.create(ReactiveTraining.exceptionMonoOnErrorContinue("Hello there"))
                .expectNext("Hello there")
                .verifyComplete();
    }
}
