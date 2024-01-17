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
}
