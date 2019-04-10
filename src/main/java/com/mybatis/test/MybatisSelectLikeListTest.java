package com.mybatis.test;

import com.mybatis.po.Customer;
import com.mybatis.util.SqlSessionBuilder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Package: com.mybatis.test
 * DESCRIPTION: 测试实体内带有list属性
 *
 * @author guxiu2008
 * @create 2019-04-10 22:16
 **/
public class MybatisSelectLikeListTest {
    public static void main(String[] args) {
        // SqlSession的生成替换成单例获取
        SqlSession sqlSession = SqlSessionBuilder.getSeesion();

        // 4.SqlSession执行映射文件中定义的SQL, 并返回结果
        List<Customer> list = sqlSession.selectList("com.mybatis.po.CustomerMapper.findCustomerListByName1", "j");

        // 打印输出结果
        for (Customer customer: list) {
            System.out.println(customer.toString());
        }

        // 5.关闭SqlSession
        sqlSession.close();
    }
}
