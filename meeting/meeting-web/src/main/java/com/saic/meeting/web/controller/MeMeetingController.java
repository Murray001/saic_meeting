package com.saic.meeting.web.controller;

import com.saic.meeting.MeMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("meeting")
public class MeMeetingController {

    @Autowired
    MeMeetingService meetingService;


    @RequestMapping(value = "/initMeeting", method = RequestMethod.GET)
    public String initMeeting(){
        String msg = "hello";
        String result = meetingService.initMeeting();
        System.out.printf("hello");
        return msg;
    }


}
