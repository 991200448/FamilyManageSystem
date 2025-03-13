package com.daisypig.common.entity;
import lombok.Data;

import java.util.Date;

/**
 * 家庭成员信息实体类，对应数据库中的 family_members 表
 * 用于存储家庭成员的详细信息，与家庭信息关联
 */
@Data
public class FamilyMembers {
    /**
     * 成员 ID，作为成员的唯一标识，自增长
     */
    private Integer memberId;
    /**
     * 所属家庭的 ID，关联 families 表中的 familyId
     */
    private Integer familyId;
    /**
     * 成员姓名，不能为空
     */
    private String memberName;
    /**
     * 成员性别，取值为 'M'（男）或 'F'（女）
     */
    private String memberGender;
    /**
     * 成员生日
     */
    private Date memberBirthday;
    /**
     * 成员与家庭主人的关系，如 '父亲'、'母亲' 等
     */
    private String memberRelationship;
    /**
     * 成员联系电话
     */
    private String memberPhone;
    /**
     * 成员电子邮箱
     */
    private String memberEmail;
}