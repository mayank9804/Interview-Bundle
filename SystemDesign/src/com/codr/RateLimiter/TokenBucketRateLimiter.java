package com.codr.RateLimiter;

import com.codr.RateLimiter.rulesRetriever.RulesRetriever;
import com.codr.RateLimiter.rulesRetriever.StaticHashMapRulesRetriever;
import com.codr.RateLimiter.rulesRetriever.model.Rule;
import com.codr.SampleSystem.UserRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Uses token bucket algorithm, where the bucket comprises tokens
 * and for every request a token is consumed. For every client burst (β) and rate (r) is defined.
 * The burst capacity β is the maximum number of requests that the server is allowed to handle immediately for each key (the "bucket size").
 * Each request consumes a token from the bucket. When the bucket is empty, requests are rejected ("throttled"). Tokens are added back to the bucket uniformly at rate r.
 * So the long-term average request rate is held close to r, while allowing periodic bursts of requests of up to size β.
 */
public class TokenBucketRateLimiter implements RateLimiter {

    private Map<String, Bucket> keyBucketMap;

    public TokenBucketRateLimiter() {
        RulesRetriever rulesRetriever = new StaticHashMapRulesRetriever();
        Rule rule = rulesRetriever.retrieve("service1");
        keyBucketMap = new HashMap<String, Bucket>() {{
            put("service1", new Bucket(rule.getBurst(), rule.getBurst(), rule.getRate(), new Date().getTime()));
        }};
    }

    @Override
    public boolean allowRequest(UserRequest userRequest) {
        long requestTime = userRequest.getTimestamp().getTime();
        Bucket bucket = keyBucketMap.get(userRequest.getKey());

        fillBucket(bucket, requestTime);
        if (bucket.tokens > 0) {
            bucket.tokens --;
            return true;
        }
        return false;
    }

    private void fillBucket(Bucket bucket, long requestTime) {
        if (bucket.tokens == bucket.burst) return;
        int refillTokenCount =  (int) Math.floor((requestTime - bucket.lastUpdateTimeStamp) * 0.0003);
        if (bucket.tokens + refillTokenCount > bucket.burst) bucket.tokens = bucket.burst;
        else bucket.tokens = bucket.tokens + refillTokenCount;
        bucket.lastUpdateTimeStamp = requestTime;
    }
}

class Bucket {
    public int tokens;
    public int burst;
    public int rate;
    public long lastUpdateTimeStamp;

    public Bucket(int tokens, int burst, int rate, long lastUpdateTimeStamp) {
        this.tokens = tokens;
        this.burst = burst;
        this.rate = rate;
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }
}