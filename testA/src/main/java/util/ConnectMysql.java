package util;

import org.apache.ibatis.annotations.Results;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/4.
 * 连接数据库
 * 该类主要是连接数据，返回resultset集合
 */
public class ConnectMysql {

    /**
     * 连接数据库,得到一个connection
     * @param sql
     * @return
     * @throws Exception
     * 静态方法可以用类名访问，
     */
    public static Connection getConn() throws Exception {
        ReaderProperties readerProperties = new ReaderProperties();
        Map<String,String> params = readerProperties.getPropertiest("F:/test001/testA/src/main/resources/db.properties");
        System.out.println(params);
        String driver = params.get("driver");
        String url = params.get("url");
        String password = params.get("password");
        String username = params.get("username");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册jdbc驱动
            Class.forName(driver);
            //打开连接
            connection = DriverManager.getConnection(url,username,password);
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 插入方法
     */
    public static void insertCaseMethod(String sql) throws Exception {
//        ConnectMysql connectMysql = new ConnectMysql();
        Connection connection = ConnectMysql.getConn();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,"接口名称");
        preparedStatement.setString(2,"请求方法");
        preparedStatement.setString(3, "body");
        preparedStatement.setString(4,"url");
        preparedStatement.setString(5,"header");
        preparedStatement.executeUpdate();
        connection.close();
        System.out.println("插入数据成功");

    }


    /**
     * 连接数据库，并且执行查询
     * @param sql
     * @return
     * @throws Exception
     */

    public ResultSet getConnect(String sql) throws Exception {
        ReaderProperties readerProperties = new ReaderProperties();
        Map<String,String> params = readerProperties.getPropertiest("F:/test001/testA/src/main/resources/db.properties");
        System.out.println(params);
        String driver = params.get("driver");
        String url = params.get("url");
        String password = params.get("password");
        String username = params.get("username");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册jdbc驱动
            Class.forName(driver);
            //打开连接
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }




}
