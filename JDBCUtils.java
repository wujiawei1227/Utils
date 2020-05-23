package com.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: algorithm
 * @description: JDBC 工具类 使用Durid连接池
 * @author: wudaren
 * @create: 2020-05-03 20:26
 **/

public class JDBCUtils {
    private  static DataSource ds;
    static {
        try {
            //加载配置文件
            Properties pro = new Properties();
            //使用class loader加载配置文件，获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //初始化连接池对象
            ds= DruidDataSourceFactory.createDataSource(pro);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    *
     * @Description //TODO 获取链接connection对象
     * @Param []
     * @return java.sql.Connection
     **/
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    /*
    *
     * @Description //TODO 获取连接池对象
     * @Param []
     * @return javax.sql.DataSource
     **/
    public static DataSource getDataSource(){
        return ds;
    }
    
}
