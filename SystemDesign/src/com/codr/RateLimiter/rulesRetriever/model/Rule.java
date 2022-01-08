package com.codr.RateLimiter.rulesRetriever.model;

/**
 * Throttling rule model.
 */
public class Rule {
    private int burst;
    private int rate;

    public Rule(int burst, int rate) {
        this.burst = burst;
        this.rate = rate;
    }

    public int getBurst() {
        return burst;
    }

    public int getRate() {
        return rate;
    }
}
