package com.yang.order_service_feign.controller;

import java.util.ArrayList;
import java.util.List;

import com.yang.order_service_feign.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    MemberService ms;

    @RequestMapping("/getUserList")
    public List<String> getUsers() {
        return ms.getUsers();
    }

    @RequestMapping("/temps")
    public List<String> temps() {
        List<String> list = new ArrayList<String>();
        list.add("yjs");
        list.add("123");
        return list;
    }
}
