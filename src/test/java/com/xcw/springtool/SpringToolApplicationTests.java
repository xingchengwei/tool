package com.xcw.springtool;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xcw.springtool.bean.Attribute;
import com.xcw.springtool.bean.Category;
import com.xcw.springtool.bean.DiscussPost;
import com.xcw.springtool.dao.AttributeDao;
import com.xcw.springtool.dao.CategoryDao;
import com.xcw.springtool.dao.DiscussPostDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootTest
@Slf4j
class SpringToolApplicationTests {

    @Test
    void runPython() throws Exception{
        String pyFile="D:\\BaiduNetdiskDownload\\waterRPA\\waterRPA.py";
        String[] cmd={"python",pyFile,"1"};
        Process exec = Runtime.getRuntime().exec(cmd);
        BufferedReader reader=new BufferedReader(new InputStreamReader(exec.getInputStream(),"gbk"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        exec.waitFor();
        reader.close();
    }

    @Autowired
    DiscussPostDao discussPostDao;

    @Autowired
    CategoryDao categoryDao;

    @Test
    void testMybatisPlus(){
        Category a = new Category();
        a.setName("电视");
        Category b = new Category();
        b.setName("电脑");
        Category c = new Category();
        c.setName("平衡车");
        Category d = new Category();
        d.setName("电热水器");
        Category e = new Category();
        e.setName("沙发");
        Category f = new Category();
        f.setName("马桶");
        categoryDao.insert(a);
        categoryDao.insert(b);
        categoryDao.insert(c);
        categoryDao.insert(d);
        categoryDao.insert(e);
        categoryDao.insert(f);
        List<Category> categories = categoryDao.selectList(null);
        System.out.println(categories);;
    }

    @Autowired
    AttributeDao attributeDao;

    @Test
    void testAttribute(){
        QueryWrapper<Category> categoryWrapper = new QueryWrapper<>();
        categoryWrapper.lambda().eq(Category::getName,"电视");
        Category category = categoryDao.selectList(categoryWrapper).get(0);
        Attribute a = new Attribute();
        a.setAttributeName("屏幕尺寸");
        a.setCategoryId(category.getCategoryId());
        Attribute b = new Attribute();
        b.setCategoryId(category.getCategoryId());
        b.setAttributeName("能效等级");
        Attribute c = new Attribute();
        c.setCategoryId(category.getCategoryId());
        c.setAttributeName("供应商");
        attributeDao.insert(a);
        attributeDao.insert(b);
        attributeDao.insert(c);
        System.out.println(attributeDao.selectList(null));
    }

}
