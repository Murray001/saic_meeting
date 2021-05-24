package com.saic.meeting.dao;

import com.saic.meeting.model.MeMeetingAm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MeMeetingDao {
    int save(MeMeetingAm am);
}
