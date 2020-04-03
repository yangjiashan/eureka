package com.yang.member_service.controller;

import java.util.*;

import com.yang.member_service.dao.idao.test;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    test test;

    @RequestMapping("/getUserList")
    public List<String> getUserList() {
        List<String> listUser = new ArrayList<String>();
        listUser.add("zhangsan");
        listUser.add("lisi");
        listUser.add("yushengjun");
        listUser.add("端口号:" + serverPort);
        return listUser;
    }

    @RequestMapping("/getMemberList")
    public String getMemberList() {
        return "MemberList project";
    }

    @RequestMapping("/getOrgById")
    public String getOrgById(){
        System.out.println(test.findObjectById("7CE7B1670C4D433ABA7F7CBEA2F7733A"));
        return "sucess";
    }

    public static void main(String[] args) {
//        List<Map<String, Object>> resultList = new ArrayList<>();
//        Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put(null,"1");
//        resultMap.put("","2");
//        resultMap.put("abcDFT","2");
//        resultList.add(resultMap);
//
//        Map<String, Object> resultMap2 = new HashMap<>();
//        resultMap2.put(null,"1");
//        resultMap2.put("","2");
//        resultMap2.put("456YRR_234$#","2");
//        resultList.add(resultMap2);
//        System.out.println(resultList);
//        System.out.println(transformLowerCase(resultList));
    }


    // 将map值全部转换为小写
    public static List<Map<String, Object>> transformLowerCase(List<Map<String, Object>> paramList) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        if (paramList == null || paramList.isEmpty()) {
            return paramList;
        }
        for (Map<String, Object> map : paramList) {
            if (map == null) {
                resultList.add(map);
                continue;
            }
            Set<String> keySet = map.keySet();
            Map<String, Object> resultMap = new HashMap<>();
            for (String key : keySet) {
                String newKey = key;
                if (!StringUtils.isBlank(key)) {
                    newKey = key.toLowerCase();
                }
                resultMap.put(newKey, map.get(key));
            }
            resultList.add(resultMap);
        }
        return resultList;
    }
}
