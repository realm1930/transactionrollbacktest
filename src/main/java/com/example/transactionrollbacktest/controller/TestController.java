package com.example.transactionrollbacktest.controller;

import com.example.transactionrollbacktest.services.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

@Controller
@RequestMapping("/")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public ModelAndView modelAndView(){
        testService.testMethod1();
        testService.testMethod2();
        testService.testMethod3();
        return new ModelAndView("index");
    }




}
