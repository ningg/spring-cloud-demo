package top.ningg.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.ningg.cloud.model.User;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${user.serviceUrl}")
    private String userServiceUrl;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${user.serviceName}")
    private String userServiceName;

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") long userId) {
        // Note: 使用 Ribbon 之后, 就无法直接调用 remote service 了, 必须经过 eureka 去发现服务
        return restTemplate.getForObject(userServiceUrl + userId, User.class);
    }

    @GetMapping("/user/{userId}/withEurekaAndRibbon")
    public User getUserByIdWithEurekaAndRibbon(@PathVariable("userId") long userId) {
        return restTemplate.getForObject(String.format("http://%s/", userServiceName) + userId, User.class);
    }

    @GetMapping("/userInstance")
    public List<ServiceInstance> getUserServiceList() {
        return discoveryClient.getInstances(userServiceName);
    }
}
