package com.springboot.web;

import com.springboot.service.SpringCloudTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WIN on 2017/10/16.
 */
@RestController
public class SpringcloudServerController {

    @Autowired
    private SpringCloudTestService springCloudTestService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return springCloudTestService.addService();
    }

}