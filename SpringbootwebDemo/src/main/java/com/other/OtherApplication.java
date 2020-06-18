package com.other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//public class DemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//}

@ComponentScan(basePackages={"com.config","com.other"})

@SpringBootApplication
public class OtherApplication extends SpringBootServletInitializer {
     
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(OtherApplication.class);
    }
 
     
    public static void main(String[] args) {
        SpringApplication.run(OtherApplication.class, args);
    }
}