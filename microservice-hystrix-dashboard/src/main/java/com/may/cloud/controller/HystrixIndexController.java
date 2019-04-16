package com.may.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wujc
 * @ClassName HystrixIndexController
 * @Description: TODO
 * @create 2019-04-14
 */
@Controller
public class HystrixIndexController {
    @GetMapping("")
    public String index() {
        return "forward:/hystrix";
    }
}
