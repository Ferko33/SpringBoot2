package com.ferko.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("user")
// MyBatisPlus 是根据实体类名称和数据库表名 对应，
// 如果名称不一致，需要使用注解 @TableName("user") 指定表名
public class User {
    /**
     * 存在的所有属性，必须都在数据库中有相应字段映射
     * 临时属性，可以使用@TableField(exist = false)
     */
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String passWord;

    //以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
