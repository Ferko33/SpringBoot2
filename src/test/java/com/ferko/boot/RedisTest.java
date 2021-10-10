package com.ferko.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("hello1", "world");
        String hello = operations.get("hello");
        System.out.println(
                hello
        );
    }
}
