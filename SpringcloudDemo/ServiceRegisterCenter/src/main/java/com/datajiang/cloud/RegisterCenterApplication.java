package com.datajiang.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.datajiang.cloud"})
@EnableEurekaServer
public class RegisterCenterApplication extends SpringBootServletInitializer {

    private static Logger logger = LoggerFactory.getLogger(RegisterCenterApplication.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext application = SpringApplication.run(RegisterCenterApplication.class, args);
        if (logger.isDebugEnabled()) {
            String[] beanDefinitionNames = application.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                logger.debug(beanName);
            }
        }
    }
}