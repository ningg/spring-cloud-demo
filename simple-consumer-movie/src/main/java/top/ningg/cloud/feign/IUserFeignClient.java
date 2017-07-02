package top.ningg.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.ningg.cloud.model.User;

@FeignClient("microservice-provider-user")
public interface IUserFeignClient {

    /**
     * Note: 因为已经使用的 Eureka 和 Ribbon, 所以, 此处 Feign 获得的就是负载均衡之后的结果。
     *
     * @param userId 用户Id
     * @return 用户对象
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User findById(@PathVariable("userId") long userId);
}
