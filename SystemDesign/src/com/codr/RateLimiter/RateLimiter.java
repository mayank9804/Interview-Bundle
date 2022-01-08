package com.codr.RateLimiter;

import com.codr.SampleSystem.UserRequest;

/**
 * An interface for different algorithmic implementation of rate limiters.
 * Can be implemented as aspect to be distributed as library.
 */
public interface RateLimiter {
    boolean allowRequest(UserRequest request);
}
