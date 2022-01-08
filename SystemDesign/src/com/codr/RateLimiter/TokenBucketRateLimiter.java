package com.codr.RateLimiter;

import com.codr.SampleSystem.UserRequest;

/**
 * Uses token bucket algorithm, where the bucket comprises tokens
 * and for every request a token is consumed. For every client burst (β) and rate (r) is defined.
 * The burst capacity β is the maximum number of requests that the server is allowed to handle immediately for each key (the "bucket size").
 * Each request consumes a token from the bucket. When the bucket is empty, requests are rejected ("throttled"). Tokens are added back to the bucket uniformly at rate r.
 * So the long-term average request rate is held close to r, while allowing periodic bursts of requests of up to size β.
 */
public class TokenBucketRateLimiter implements RateLimiter {
    @Override
    public boolean allowRequest(UserRequest userRequest) {
        return false;
    }
}
