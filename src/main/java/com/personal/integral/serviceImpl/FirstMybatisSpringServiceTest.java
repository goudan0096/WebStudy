package com.personal.integral.serviceImpl;

import com.personal.integral.entity.Country;
import com.personal.integral.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstMybatisSpringServiceTest {
    @Autowired
    private CountryMapper countryMapper;

    public  Country selectByPrimaryKey(Integer id){
        return countryMapper.selectByPrimaryKey(id);
    }

}
