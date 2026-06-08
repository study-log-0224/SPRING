package com.example.demo.Controller.GlobalException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//    @ExceptionHandler(FileNotFoundException.class)
//    public String exeptionHandler_1(Exception e, Model model) {
//        log.error("[Global]ExceptionTestController ex1 : " + e);
//        model.addAttribute("e",e);
//        return "global/error1";
//    }
//    @ExceptionHandler(ArithmeticException.class)
//    public String exeptionHandler_2(Exception e, Model model) {
//        log.error("[Global]ExceptionTestController ex2 : " + e);
//        model.addAttribute("e",e);
//        return "global/error2";
//    }
//    @ExceptionHandler(Exception.class)
//    public String exeptionHandler_All(Exception e, Model model) {
//        log.error("[Global] etc exceptions : " + e);
//        model.addAttribute("e",e);
//        return "global/error3";
//    }
}
