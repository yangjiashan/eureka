package com.yang.order_service_feign.service;

import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "member-service", fallback = MemberFeignService.class)
public interface MemberService {

    @RequestMapping("/getUserList")
    @LoadBalanced
    public List<String> getUsers();
}
