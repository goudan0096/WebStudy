package com.personal.integral.serviceImpl;

import cn.edu.hfut.dmic.webcollector.crawler.AutoParseCrawler;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

public class MyFirstWebCollectorServiceTest extends BreadthCrawler {

    private String zsBankUrl="http://jf.cmbchina.com";
    private int count = 0;

    public MyFirstWebCollectorServiceTest(String crawlPath,boolean autoParse){
        super(crawlPath,autoParse);
        this.addSeed(zsBankUrl);
        //this.addRegex("jf.cmbchina.com/SubCategory/*.htm");
        this.addRegex("http://jf.cmbchina.com/SubCategory/.*.htm");
        this.addRegex("http://jf.cmbchina.com/Product/.*.htm");
        //getConf().setTopN(100);

    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        String url = page.url();
        if(url.matches("http://jf.cmbchina.com/SubCategory/.*.htm")){
            //crawlDatums.add(url);
            //this.addSeed(url);
        }else if (url.matches("http://jf.cmbchina.com/Product/.*.htm")){
            //System.out.println(url.toString());
            String productName = page.select("h1").text();
            String label = page.select("span[class=credit]span[id=CurrentInstamllPhase]").text();
            System.out.println("---------------------------------"+(++count));
            System.out.println("+++++++++++++++++++++++++++++++++"+productName);

        }else{
            System.out.println("+++++++++++++++++++++++++++++++++");
        }
    }

    public static void main(String args[]){
        MyFirstWebCollectorServiceTest myFirstWebCollectorServiceTest = new MyFirstWebCollectorServiceTest("crawl",true);
        try {
            myFirstWebCollectorServiceTest.start(5);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
