// package hello;
package org.telecom.infinispan.cache.solution;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {

        // cacheManager.getCache("testCache").put("testKey", "testValue");
        // System.out.println("Received value from cache: " + cacheManager.getCache("testCache").get("testKey"));

        return "Greetings from Spring Boot! Implementing infinispan";
    }
    
}
