package com.saic.meeting.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan(basePackages ="com.saic.meeting")
public class MeetingWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingWebApplication.class, args);
    }

}
