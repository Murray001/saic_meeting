package com.saic.meeting;


import com.saic.meeting.model.MeMeetingAm;

import java.util.List;

public interface MeMeetingService {
    String initMeeting(MeMeetingAm am);

    List<MeMeetingAm> query(MeMeetingAm am);
}
