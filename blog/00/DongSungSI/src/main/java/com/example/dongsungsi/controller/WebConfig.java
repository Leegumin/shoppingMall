package com.example.dongsungsi.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * packageName : com.example.dongsungsi.config
 * fileName : webConfig
 * author : gumin
 * date : 2022-06-14
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-14         gumin          최초 생성
 */
// 환경설정파일은 아래 어노테이션을 활용
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // @CrossOrigin 어노테이션과 동일함

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // addMapping(**) : springboot 서버로 들어오는 모든 요청을 받겠다.
        registry.addMapping("/**")
                // http://localhost:8080 <- 이 주소로 들어오는 요청을 모두 허용하겠다.
                .allowedOrigins("http://localhost:8080");
    }
}
