package com.datajiang.cloud.controller;

import com.datajiang.cloud.client.HelloRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsumerController {
    private Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired(required = false)
    HelloRemote HelloRemote;

//    @RequestMapping(value = "hello", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
//    @ResponseBody
//    public String syncCloudResource() {
//        try {
//            return "Hello";
//        } catch (Exception e) {
//            logger.error("ResourcepoolController.syncCloudResource(){}:", e);
//            return "Failed";
//        }
////        return "I Dont know!";
//    }

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return HelloRemote.hello(name);
    }
}

