package com.codr.RateLimiter.rulesRetriever;

import com.codr.RateLimiter.rulesRetriever.model.Rule;

import java.util.HashMap;
import java.util.Map;

/**
 * Uses a static hashmap to retrieve rules for a key.
 */
public class StaticHashMapRulesRetriever implements RulesRetriever {
    private Map<String, Rule> rulesStore;

    public StaticHashMapRulesRetriever() {
        // Per 10 second time period.
        this.rulesStore = new HashMap<String, Rule>() {{
            put("service1", new Rule(3,3));
        }};
    }

    @Override
    public Rule retrieve(String key) {
        return rulesStore.get(key);
    }
}
