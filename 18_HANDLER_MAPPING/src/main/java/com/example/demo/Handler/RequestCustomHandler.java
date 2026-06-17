package com.example.demo.Handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RequestCustomHandler{

    public String helloWorld(){
        System.out.println("[HANDLER] RequestCustomHandler's helloWorld invoke..");
        return "memo/add";
    }

    @ResponseBody
    public String helloWorld2(){
        System.out.println("[HANDLER] RequestCustomHandler's helloWorld2 invoke..");
        return "HELLOWORLD!!!!!!!";
    }

}
