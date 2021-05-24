package com.saic.meeting.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"com.saic.meeting.web"})
@Configuration
@MapperScan(basePackages ="com.saic.meeting.dao")
@ComponentScan(value = {"com.saic.meeting.web","com.saic.meeting.service","com.saic.meeting.api","com.saic.meeting.model"})
public class MeetingWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingWebApplication.class, args);
    }

}
