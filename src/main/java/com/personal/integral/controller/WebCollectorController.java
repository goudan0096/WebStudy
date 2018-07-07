package com.personal.integral.controller;

import com.personal.integral.serviceImpl.ManualNewsCrawlerServiceTest;
import com.personal.integral.serviceImpl.WebCollectorServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/WebCollectorController")
@ResponseBody
public class WebCollectorController {
    private static final Logger logger = LoggerFactory.getLogger(WebCollectorController.class);

    @RequestMapping("collectTest.do")
    public  String test(){
        //输出日志文件
        logger.info("test collector");
        //返回一个index.jsp这个视图
        WebCollectorServiceTest crawler = new WebCollectorServiceTest("crawl", true);
        /*start crawl with depth of 4*/
        try {
            crawler.start(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping("ManualNewsCrawler.do")
    @ResponseBody
    public String ManualNewsCrawlerTest(){
        ManualNewsCrawlerServiceTest crawler = new ManualNewsCrawlerServiceTest("crawl", false);

        crawler.getConf().setExecuteInterval(50);

        crawler.getConf().set("title_prefix","PREFIX_");
        crawler.getConf().set("content_length_limit", 20);

        /*start crawl with depth of 4*/
        try {
            crawler.start(4);
        } catch (Exception e) {
            e.printStackTrace();
            return  "ManualNewsCrawler error";
        }
        return "ManualNewsCrawler ok";
    }
}
