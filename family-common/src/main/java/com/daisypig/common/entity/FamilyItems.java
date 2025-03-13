package com.daisypig.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 家庭物品信息实体类，对应数据库中的 family_items 表
 * 用于管理家庭中的各类物品信息，与家庭信息关联
 */
@Data
public class FamilyItems {
    /**
     * 物品 ID，作为物品的唯一标识，自增长
     */
    private Integer itemId;
    /**
     * 所属家庭的 ID，关联 families 表中的 familyId
     */
    private Integer familyId;
    /**
     * 物品名称，不能为空
     */
    private String itemName;
    /**
     * 物品类型，如 '家具'、'电器' 等
     */
    private String itemType;
    /**
     * 物品购买日期
     */
    private Date purchaseDate;
    /**
     * 物品购买价格，精确到小数点后两位
     */
    private Double purchasePrice;
    /**
     * 物品存放位置
     */
    private String location;
    /**
     * 物品状态，如 '正常'、'损坏' 等
     */
    private String status;
    /**
     * 物品描述信息
     */
    private String description;
}