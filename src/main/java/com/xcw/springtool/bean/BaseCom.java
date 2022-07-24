package com.xcw.springtool.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseCom implements Serializable {

    @TableField(exist = false)
    private int pageNum=1;

    @TableField(exist = false)
    private int pageSize=5;
}
