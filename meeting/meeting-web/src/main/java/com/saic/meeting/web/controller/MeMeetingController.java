package com.saic.meeting.web.controller;

import com.saic.meeting.MeMeetingService;
import com.saic.meeting.model.MeMeetingAm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("meeting")
public class MeMeetingController {

//    @Autowired(required = false)
    @Autowired
    private MeMeetingService meMeetingService;


    @RequestMapping(value = "/initMeeting", method = RequestMethod.GET)
    @ResponseBody
    public String initMeeting(){
        String msg = "hello";
        MeMeetingAm am = new MeMeetingAm();
        String result = meMeetingService.initMeeting(am);
        System.out.printf(result);
//        return result;
        return msg;
    }


}
