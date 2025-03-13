package com.daisypig.common.entity;
import lombok.Data;

import java.util.Date;

/**
 * 家庭收支信息实体类，对应数据库中的 family_finances 表
 * 用于记录家庭的收入和支出情况，与家庭和成员信息关联
 */
@Data
public class FamilyFinances {
    /**
     * 收支记录的 ID，作为唯一标识，自增长
     */
    private Integer financeId;
    /**
     * 所属家庭的 ID，关联 families 表中的 familyId
     */
    private Integer familyId;
    /**
     * 操作成员的 ID，关联 family_members 表中的 memberId
     */
    private Integer memberId;
    /**
     * 交易类型，取值为 '收入' 或 '支出'
     */
    private String transactionType;
    /**
     * 交易日期，不能为空
     */
    private Date transactionDate;
    /**
     * 收支金额，精确到小数点后两位
     */
    private Double amount;
    /**
     * 收支类别，如 '工资'、'水电费' 等
     */
    private String category;
    /**
     * 收支描述信息
     */
    private String description;
}