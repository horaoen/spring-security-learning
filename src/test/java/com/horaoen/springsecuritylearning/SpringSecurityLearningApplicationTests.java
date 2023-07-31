package com.horaoen.springsecuritylearning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.function.Supplier;

class SpringSecurityLearningApplicationTests {

    @Test
    void stopWatchTest() {
        String password = "123456";

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("matches password");
        passwordEncoder.matches(password, encodedPassword);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }
    
    @Test
    void supplierTest() {
        HashMap<String, String> cache = new HashMap<>();
        cache.put("data", "hello");
        String key = "data";

        String s = cache.computeIfAbsent(key, (k) -> {
            return k + "and a";
        });

        System.out.println(s);
    }
    
    private Supplier<String> defaultValue() throws InterruptedException {
        System.out.println("waked after 1 second...");
        Thread.sleep(1000);
        
        // fake fetchData from database
        return () -> "aaa";
    }

}
