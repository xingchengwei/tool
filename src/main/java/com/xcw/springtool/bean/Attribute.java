package com.xcw.springtool.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Attribute {

    @TableId
    private int attributeId;

    private String attributeName;

    private int categoryId;

    @TableField(exist = false)
    private String categoryName;
}
