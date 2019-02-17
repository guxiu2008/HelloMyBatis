package com.mybatis.test;

import com.mybatis.po.Customer;
import com.mybatis.util.SqlSessionBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.io.InputStream;

/**
 * Package: com.mybatis.test
 * DESCRIPTION:
 *
 * @author guxiu2008
 * @create 2019-02-13 8:24
 **/
public class MybatisDeleteTest {

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
        // 4.1 执行SqlSession的更新方法,返回的是SQL语句影响的行数
        int rows = sqlSession.delete("com.mybatis.po.CustomerMapper.deleteCustomer", 5);

        // 4.2 通过返回结果判断更新操作是否执行成功
        // 针对增删改的SQL，mybatis在执行完的时候基本都会返回变更的条数，如果SQL存在语法等问题导致无法执行，一般都会通过报异常的方式报错，而不会返回数值。
        if (rows > 0) {
            System.out.println("成功产出了" + rows + "条数据!");
        } else {
            System.out.println("执行删除操作失败!");
        }

        // 4.3 提交事务
        // 经过测试,如果sqlSession不主动commit数据,SQL执行完毕的事务是会自动回退的
        sqlSession.commit();

        // 5.关闭SqlSession
        sqlSession.close();
    }
}
