package com.personal.integral.controller;

import com.personal.integral.entity.Country;
import com.personal.integral.serviceImpl.FirstMybatisSpringServiceTest;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping("/mybatis")
public class MyBatisController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(MyBatisController.class);

    @Autowired
    private FirstMybatisSpringServiceTest firstMybatisSpringServiceTest;

    //映射一个action
    @RequestMapping("/test/getAll.action")
    @ResponseBody
    public  String getAllCountry(@RequestParam("id") int id){
        //输出日志文件
        logger.info("mybatis test !");
        Country country = firstMybatisSpringServiceTest.selectByPrimaryKey(id);
        return "mybatis test";
    }
}
