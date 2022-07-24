package com.xcw.springtool.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class DiscussPost extends BaseCom{

    @TableId
    private int id;

    private int userId;

    // 互联网校招
    private String title;

    private String content;

    private int type;

    private int status;

    private Date createTime;

    private int commentCount;

    private double score;
}
