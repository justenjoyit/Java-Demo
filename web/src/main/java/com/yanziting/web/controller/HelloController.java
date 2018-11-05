package com.yanziting.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ziting.Yan
 * @since : 2018-08-07-16-48
 **/
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/hello")
    public String hello() {
        logger.info("sss");
        return "hello";
    }
}
