package com.saic.meeting.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.saic.meeting.dao")
public class MeetingWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingWebApplication.class, args);
    }

}
