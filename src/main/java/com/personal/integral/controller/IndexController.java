package com.personal.integral.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    //映射一个action
    @RequestMapping("/welcome/{test}")
    @ResponseBody
    public  String index(@PathVariable("test") String test){
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        return "welcome "+test+" !";
    }

    //映射一个action
    @RequestMapping("/test")
    public  String test(){
        //输出日志文件
        logger.info("test pages");
        //返回一个index.jsp这个视图
        return "jsp/welcome";
    }

    //velocity
    @RequestMapping("/velocity")
    public  ModelAndView testVelocity(){
        ModelAndView mav = new ModelAndView("velocity");
        //输出日志文件
        logger.info("velocity pages");
        //返回一个index.jsp这个视图
        return mav;
    }

}
