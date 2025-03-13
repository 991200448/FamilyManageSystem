package com.daisypig.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("user") // 表名，类名=表名时可省略
public class User {
    @TableId(type = IdType.AUTO) // 主键策略：AUTO（数据库自增）、UUID、ASSIGN_ID（雪花算法）等
    private Long id;
    private String name;
    @TableField("age") // 字段名=属性名时可省略
    private Integer age;
    @TableLogic // 逻辑删除（自动添加DELETE_FLAG字段，默认0=未删除，1=已删除）
    private Integer deleted;
    @Version // 乐观锁版本号
    private Integer version;
}