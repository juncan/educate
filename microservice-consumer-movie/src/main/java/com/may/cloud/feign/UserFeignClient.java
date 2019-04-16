package com.may.cloud.feign;

import com.may.cloud.domian.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wujc
 * @ClassName UserFeignClient
 * @Description: TODO
 * @create 2019-04-14
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);

}
