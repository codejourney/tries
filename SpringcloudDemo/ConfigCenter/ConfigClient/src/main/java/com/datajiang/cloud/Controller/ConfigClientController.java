package com.datajiang.cloud.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    private Logger logger = LoggerFactory.getLogger(ConfigClientController.class);



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


    @Value("${neo.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
}
