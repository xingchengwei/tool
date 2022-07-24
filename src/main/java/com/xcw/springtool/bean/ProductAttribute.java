package com.xcw.springtool.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ProductAttribute {

    @TableId
    private int productAttributeId;

    private int productId;

    private int attributeId;

    private String attributeValue;

}
