package com.saic.meeting.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MeMeetingAm implements Serializable {

    private Long meetingId;
    private Long userId;
    private Integer meetingType;
    private String orgCode;
    private String dealerCode;
    private String dealerName;
    private String meetingDate;
    private String meetingAddress;
    private String longitude;
    private String latitude;
    private Long createBy;
    private Date createDate;
    private Long updateBy;
    private Date updateDate;

}
