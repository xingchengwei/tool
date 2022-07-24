package com.xcw.springtool.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcw.springtool.bean.ApiResponseBody;
import com.xcw.springtool.bean.DiscussPost;
import com.xcw.springtool.bean.PageResult;
import com.xcw.springtool.dao.DiscussPostDao;
import com.xcw.springtool.service.DiscussPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Slf4j
public class IndexController {

//    @Autowired
//    private DiscussPostService discussPostService;

    @Autowired
    private DiscussPostDao discussPostDao;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ApiResponseBody<String> index() {
        return ApiResponseBody.success("hello success");
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResponseBody<PageResult<DiscussPost>> list(@RequestBody DiscussPost discussPost) {
        log.info("查询的条件：{}", discussPost);
        QueryWrapper<DiscussPost> queryWrapper = new QueryWrapper<>();
        HashMap<String, Object> paraMap = new HashMap<>();
        paraMap.put("id", discussPost.getId());
        paraMap.put("user_id", discussPost.getUserId());
        paraMap.put("title", discussPost.getTitle());
        paraMap.put("content", discussPost.getContent());
        paraMap.put("type",discussPost.getType());
        queryWrapper.allEq(paraMap, false);

        IPage<DiscussPost> page = new Page<>(discussPost.getPageNum(), discussPost.getPageNum());
        page=discussPostDao.selectPage(page, queryWrapper);
        PageResult<DiscussPost> discussPostPageResult = new PageResult<>();
        discussPostPageResult.setPageNo(discussPost.getPageNum());
        discussPostPageResult.setPageSize(discussPost.getPageSize());
        discussPostPageResult.setTotalPages(page.getTotal());
        discussPostPageResult.setResult(page.getRecords());
        log.info("查询的数据：{}",page.getRecords());

        return ApiResponseBody.success(discussPostPageResult);
    }
}
