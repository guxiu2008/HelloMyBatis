package com.mybatis.test;

import com.mybatis.po.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Package: com.mybatis.test
 * DESCRIPTION: 模糊查询
 *
 * @author guxiu2008
 * @create 2019-02-13 8:24
 **/
public class MybatisSelectLikeTest {

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
        List<Customer> list = sqlSession.selectList("com.mybatis.po.CustomerMapper.findCustomerByName1", "j");

        // 打印输出结果
        for (Customer customer: list) {
            System.out.println(customer.toString());
        }

        // 5.关闭SqlSession
        sqlSession.close();
    }
}
