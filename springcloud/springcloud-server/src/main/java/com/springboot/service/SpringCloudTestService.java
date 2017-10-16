package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by WIN on 2017/10/16.
 */
@Service
public class SpringCloudTestService {

    @Autowired
    RestTemplate restTemplate;

    public String addService() {
//        return "123";
        return restTemplate.getForEntity("http://SPRINGCLOUD-SERVICE/add?a=10&b=20", String.class).getBody();
    }

}
