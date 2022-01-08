package com.codr.RateLimiter;

import com.codr.RateLimiter.rulesRetriever.RulesRetriever;
import com.codr.RateLimiter.rulesRetriever.StaticHashMapRulesRetriever;
import com.codr.RateLimiter.rulesRetriever.model.Rule;
import com.codr.SampleSystem.UserRequest;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Sliding window based rate limiter.
 * For every window of a fixed time period, algorithm based on the
 * permitted request and threshold, either throttles or allows it.
 */
public class SlidingWindowRateLimiter implements RateLimiter {

    private Queue<Date> queue;
    private static final long WINDOW_PERIOD = 10000;

    public SlidingWindowRateLimiter() {
        this.queue = new LinkedList<>();
    }

    @Override
    public boolean allowRequest(UserRequest userRequest) {
        RulesRetriever rulesRetriever = new StaticHashMapRulesRetriever();
        Rule rule = rulesRetriever.retrieve(userRequest.getKey());
        long requestTime = userRequest.getTimestamp().getTime();
        while(!queue.isEmpty() && ((requestTime - queue.peek().getTime()) > WINDOW_PERIOD)) {
            queue.remove();
        }
        if (queue.size() < rule.getBurst()) {
            queue.add(userRequest.getTimestamp());
            return true;
        }
        return false;
    }
}
