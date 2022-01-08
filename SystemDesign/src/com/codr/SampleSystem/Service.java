package com.codr.SampleSystem;

import com.codr.RateLimiter.RateLimiter;
import com.codr.RateLimiter.SlidingWindowRateLimiter;

import java.util.Date;

/**
 * A sample service that hosts an operation and can be integrated with various modules.
 */
public class Service {
    private RateLimiter rateLimiter;

    public Service() {
        this.rateLimiter = new SlidingWindowRateLimiter();
    }

    public void getBeer(UserRequest request) {
        System.out.println(String.format("Recieved request for getBeer operation from user %s, with timestamp %d",
                request.getUserId(), request.getTimestamp().getTime()));
        if (this.rateLimiter.allowRequest(request)) {
           // Do operation
            // Log performed
            System.out.println(String.format("Processed request for getBeer operation from user %s, with timestamp %d",
                    request.getUserId(), request.getTimestamp().getTime()));
        } else {
            // Throttled
            // Log throttled
            System.out.println(String.format("Throttled request for getBeer operation from user %s, with timestamp %d",
                    request.getUserId(), request.getTimestamp().getTime()));
        }
    }

    public static void main(String...args) throws Exception {
        Service service = new Service();
        Date currentDate = new Date();

        while ((new Date().getTime() - currentDate.getTime()) <= 9000) {
            service.getBeer(new UserRequest("service1", new Date(), "user1"));
            service.getBeer(new UserRequest("service1", new Date(), "user2"));
            Thread.sleep(2000);
            service.getBeer(new UserRequest("service1", new Date(), "user3"));
            service.getBeer(new UserRequest("service1", new Date(), "user4")); // should be throttled
            Thread.sleep(7000); // Wait for 7seconds, to fasten up the window closure.
        }

        currentDate = new Date();
        while ((new Date().getTime() - currentDate.getTime()) <= 10000) {
            service.getBeer(new UserRequest("service1", new Date(), "user1")); // should be throttled
            service.getBeer(new UserRequest("service1", new Date(), "user2")); // should be throttled
            Thread.sleep(2000);
            service.getBeer(new UserRequest("service1", new Date(), "user3")); // should be permitted
            Thread.sleep(10000);
        }
        System.out.println("Done");
    }
}
