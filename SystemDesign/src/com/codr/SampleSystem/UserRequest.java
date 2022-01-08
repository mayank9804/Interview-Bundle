package com.codr.SampleSystem;

import java.util.Date;

/**
 * Model denoting a request to system.
 */
public class UserRequest {
    private String key;
    private Date timestamp;
    private String userId;

    public UserRequest(String key, Date timestamp, String userId) {
        this.key = key;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    public String getKey() {
        return key;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }
}
