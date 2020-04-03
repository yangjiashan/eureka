package com.yang.order_service.controller;

import java.util.List;

import com.yang.order_service.dao.idao.test;
import com.yang.order_service.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {
    @Autowired
    MemberService services;

    @Autowired
    test test;

    @RequestMapping("/getMemberUser")
    public List<String> getMemberUser() {
        return services.getOrderByUserList();
    }

    @RequestMapping("/getOrderList")
    public String getOrderList() {
        return "OrderController project";
    }

    @RequestMapping("/getOrgById")
    public String getOrgById(){
        System.out.println(test.findObjectById("7CE7B1670C4D433ABA7F7CBEA2F7733A"));
        return "sucess";
    }
}
