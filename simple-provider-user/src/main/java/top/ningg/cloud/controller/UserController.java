package top.ningg.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.ningg.cloud.model.User;
import top.ningg.cloud.repository.IUserRepository;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private IUserRepository userRepository;

    @GetMapping("/{userId}")
    public User getById(@PathVariable("userId") long userId) {
        return userRepository.findOne(userId);
    }

}
