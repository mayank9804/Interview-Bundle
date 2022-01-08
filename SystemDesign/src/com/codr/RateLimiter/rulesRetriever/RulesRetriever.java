package com.codr.RateLimiter.rulesRetriever;

import com.codr.RateLimiter.rulesRetriever.model.Rule;

/**
 * Abstract retrievers of various sources rules can be hosted in.
 */
public interface RulesRetriever {
    Rule retrieve(String key);
}
