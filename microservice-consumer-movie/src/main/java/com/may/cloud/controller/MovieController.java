package com.may.cloud.controller;

import com.may.cloud.domian.User;
import com.may.cloud.feign.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author wujc
 * @ClassName MovieController
 * @Description: TODO
 * @create 2019-04-14
 */
@RequestMapping("/movies")
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        //User user = this.restTemplate.getForObject("http://localhost:8000/users/{id}", User.class, id);
        //User user = this.restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
        User user = userFeignClient.findById(id);
        return user;
    }

    public User findByIdFallback(Long id) {
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }
}
