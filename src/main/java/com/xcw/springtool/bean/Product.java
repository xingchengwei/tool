package com.xcw.springtool.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Product {

    @TableId
    private int productId;

    private String productName;

    private String productSubtitle;

    private double price;

    private int stockNum;

    private int categoryId;

    @TableField(exist = false)
    private String categoryName;
}
