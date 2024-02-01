package com.hcorupe.contentcalender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class ContentCalenderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ContentCalenderApplication.class, args);
        Object restTemp = context.getBean("restTemplate");
        System.out.println(restTemp);

    }

}
