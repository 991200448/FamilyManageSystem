package com.daisypig.common.entity;

import lombok.Data;

import java.util.Date;
import java.sql.Time;

/**
 * 家庭日程信息实体类，对应数据库中的 family_schedules 表
 * 用于安排和记录家庭的各种活动日程，与家庭和成员信息关联
 */
@Data
public class FamilySchedules {
    /**
     * 日程 ID，作为日程的唯一标识，自增长
     */
    private Integer scheduleId;
    /**
     * 所属家庭的 ID，关联 families 表中的 familyId
     */
    private Integer familyId;
    /**
     * 负责成员的 ID，关联 family_members 表中的 memberId
     */
    private Integer memberId;
    /**
     * 日程日期，不能为空
     */
    private Date scheduleDate;
    /**
     * 日程开始时间
     */
    private Time startTime;
    /**
     * 日程结束时间
     */
    private Time endTime;
    /**
     * 日程名称，不能为空
     */
    private String eventName;
    /**
     * 日程描述信息
     */
    private String description;
    /**
     * 日程提醒时间
     */
    private Time reminder;
}
