package com.personal.integral.test;

import com.personal.integral.entity.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MybatisTest {
    public static void main(String args[]){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            List<Country> countryList = sqlSession.selectList("selectAll");
            for(Country country:countryList){
                System.out.println(country.getCountrycode()+country.getCountryname()+country.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
