package com.xcw.springtool.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Category {

    @TableId
    private int categoryId;

    private String name;
}
