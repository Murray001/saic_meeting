package com.saic.meeting.service.Impl;

import com.saic.meeting.MeMeetingService;
import com.saic.meeting.dao.MeMeetingDao;
import com.saic.meeting.model.MeMeetingAm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeMeetingServiceImpl implements MeMeetingService {


    @Autowired
    MeMeetingDao meetingDao;


    @Override
    public String initMeeting(MeMeetingAm am) {
        am.setDealerCode("MQ2115B");
        am.setDealerName("测试1");
        am.setLongitude("105.374626");
        am.setLatitude("101.234566");
        am.setUserId(1L);
        am.setMeetingAddress("上海市闵行区富贵路101号");
        am.setMeetingDate("2021-05-24");
        am.setMeetingType(2);
        int i = meetingDao.save(am);
        return "success";
    }

    @Override
    public List<MeMeetingAm> query(MeMeetingAm am) {
        return meetingDao.query(am);
    }
}
