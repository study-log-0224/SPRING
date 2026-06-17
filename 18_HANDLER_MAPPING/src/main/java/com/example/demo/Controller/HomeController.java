package com.example.demo.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// LINK : https://junhyunny.github.io/spring-boot/filter-interceptor-and-aop/

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home() {
//        System.out.println("GET /");
        log.info("GET / ....");
        System.out.println();
        return "index";
    }
}
