package com.mybatis.test;

import com.mybatis.po.Customer;
import com.mybatis.util.SqlSessionBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Package: com.mybatis.test
 * DESCRIPTION: 模糊查询
 *
 * @author guxiu2008
 * @create 2019-02-13 8:24
 **/
public class MybatisSelectLikeMapTest {

    private static Logger logger = Logger.getLogger(MybatisSelectOneTest.class);

    public static void main(String[] args) throws IOException {

        PropertyConfigurator.configure(Resources.getResourceAsStream("log4j.properties"));

/*        // 1.读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3.通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();*/

        // SqlSession的生成替换成单例获取
        SqlSession sqlSession = SqlSessionBuilder.getSeesion();

        // 4.SqlSession执行映射文件中定义的SQL, 并返回结果
        Map<Integer, Customer> map = sqlSession.selectMap(
                "com.mybatis.po.CustomerMapper.findCustomerByName1", "j");

        // 打印输出结果
        StringBuilder key = new StringBuilder();
        for (Map.Entry<Integer, Customer> entry : map.entrySet()) {
            key.append(entry.getKey());
            Customer customer = entry.getValue();
            System.out.println("key = " + key.toString() + " , val = " + customer.toString());

            key.delete(0, key.length());
        }

        // 5.关闭SqlSession
        sqlSession.close();
    }
}
