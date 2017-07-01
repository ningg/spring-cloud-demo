package top.ningg.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.ningg.cloud.model.User;

import javax.annotation.Resource;

@RestController
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${user.serviceUrl}")
    private String userServiceUrl;

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") long userId) {
        return restTemplate.getForObject(userServiceUrl + userId, User.class);
    }
}
