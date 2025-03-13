package com.daisypig.common.entity;
import lombok.Data;

import java.util.Date;

/**
 * 家庭信息实体类，对应数据库中的 families 表
 * 用于存储家庭的基本信息，如家庭名称、地址、联系电话等
 */
@Data
public class Families {
    /**
     * 家庭 ID，作为家庭的唯一标识，自增长
     */
    private Integer familyId;
    /**
     * 家庭名称，不能为空
     */
    private String familyName;
    /**
     * 家庭住址
     */
    private String familyAddress;
    /**
     * 家庭联系电话
     */
    private String familyContact;
    /**
     * 家庭信息的创建时间，默认为当前时间
     */
    private Date createTime;
    /**
     * 家庭信息的更新时间，在数据更新时自动更新
     */
    private Date updateTime;
}