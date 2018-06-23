package com.personal.integral.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
@RequestMapping("/mybatis")
public class MyBatisController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(MyBatisController.class);

    //映射一个action
    @RequestMapping("/test/getAll.action")
    @ResponseBody
    public  String getAllCountry(){
        //输出日志文件
        logger.info("mybatis test !");
        //返回所有country
        return null;
    }
}
