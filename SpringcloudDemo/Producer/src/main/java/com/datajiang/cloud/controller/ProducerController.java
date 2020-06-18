package com.datajiang.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

    private Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @RequestMapping(value = "hello", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
//    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String index(@RequestParam String name) {
        try {
            return "form SECOND producer Hello " + name;
        } catch (Exception e) {
            logger.error("ResourcepoolController.syncCloudResource(){}:", e);
            return "Failed";
        }
//        return "I Dont know!";
    }
}
