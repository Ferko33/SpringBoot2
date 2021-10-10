package com.ferko.boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class RedisUrlCountInterceptor implements HandlerInterceptor {

//    @Autowired
//    StringRedisTemplate redisTemplatel;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        String requestURI = request.getRequestURI();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String date = simpleDateFormat.format(new Date());
//
//        //redisTemplatel.opsForValue().increment(key.toString());
//        redisTemplatel.opsForHash().increment(requestURI,date,1L);
//        return true;
//    }
}
