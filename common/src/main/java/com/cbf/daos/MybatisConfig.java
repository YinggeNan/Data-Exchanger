package com.cbf.daos;

import com.cbf.bean.Broker;
import com.cbf.mybatis.BrokerMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/6
 * @description
 */
public class MybatisConfig {
    SqlSessionFactory getSqlSessionFactory(){
        SqlSessionFactory sqlSessionFactory = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource("mybatis/mybatis-config.xml");
            InputStream inputStream = classPathResource.getInputStream();
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new MybatisConfig().getSqlSessionFactory();
        SqlSession session = null;
        try{
            session = sqlSessionFactory.openSession();
            BrokerMapper mapper = session.getMapper(BrokerMapper.class);
            List<Broker> list =  mapper.selectAll();
            System.out.println();
        }finally {
            session.close();
        }
    }
}
