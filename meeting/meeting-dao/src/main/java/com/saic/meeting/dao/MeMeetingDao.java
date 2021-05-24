package com.saic.meeting.dao;

import com.saic.meeting.model.MeMeetingAm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Mapper

@Repository
public interface MeMeetingDao {
    int save(MeMeetingAm am);
}
