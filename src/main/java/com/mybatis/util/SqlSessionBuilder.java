package com.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Package: com.mybatis.util
 * DESCRIPTION:
 *
 * @author guxiu2008
 * @create 2019-02-15 21:55
 **/
public class SqlSessionBuilder {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            // 使用SqlSessionFactory对象
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取SqlSession对象的静态方法
    public static SqlSession getSeesion() {
        return sqlSessionFactory.openSession();
    }
}
