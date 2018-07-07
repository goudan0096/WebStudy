package com.personal.integral.dao;

import com.personal.integral.controller.MyBatisController;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

public class MybatisBaseDao {
    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(MybatisBaseDao.class);

    public static void init() throws IOException{

        Reader reader = null;
        reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();

    }

    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
