package com.peter.netflix.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class IndexController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello")
    public String hello() {
        List<String> services = discoveryClient.getServices();

        for (String s : services) {
            System.out.println(s);
        }
        return "hello spring cloud";
    }
}
