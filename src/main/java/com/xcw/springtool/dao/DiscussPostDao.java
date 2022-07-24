package com.xcw.springtool.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xcw.springtool.bean.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussPostDao extends BaseMapper<DiscussPost> {


}
