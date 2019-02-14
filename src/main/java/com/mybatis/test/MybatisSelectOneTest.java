package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import com.mybatis.po.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Package: com.mybatis.test
 * DESCRIPTION: 根据ID查询一个客户信息
 *
 * @author guxiu2008
 * @create 2019-02-12 22:34
 **/
public class MybatisSelectOneTest {

    private static Logger logger = Logger.getLogger(MybatisSelectOneTest.class);

    public static void main(String[] args) throws IOException {

        PropertyConfigurator.configure(Resources.getResourceAsStream("log4j.properties"));

        // 1.读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3.通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.SqlSession执行映射文件中定义的SQL, 并返回结果
        Customer customer = sqlSession.selectOne("com.mybatis.po.CustomerMapper.findCustomerById", 1);

        // 打印输出结果
        System.out.println(customer.toString());

        // 5.关闭SqlSession
        sqlSession.close();
    }
}
