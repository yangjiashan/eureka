package com.yang.order_service_feign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemberFeignService implements MemberService{

    public List<String> getUsers() {
        List<String>listUser = new ArrayList<String>();
        listUser.add("not orderUser list");
        return listUser;
    }


}