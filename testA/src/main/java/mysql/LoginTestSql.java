package mysql;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import demo1.demo02;
import util.ConnectMysql;
import util.Processing;

/**
 * Created by Administrator on 2019/4/4.
 */
public class LoginTestSql {


    public ConnectMysql getConn;
    public Statement statement;
    public  demo02 demo02;
    @BeforeTest
    public void init() throws IOException, SQLException {
        //实例化
        getConn = new ConnectMysql();
        demo02 = new demo02();
    }



    @Test
    public  void loginTest() throws Exception {
        /**
         * sql语句，头信息，发送方法
         */
        Map<String ,Object> header = new HashMap<String,Object>();
        header.put("Content-type","text/html; charset=UTF-8");
        String sql = "SELECT interfacename,method,data,url from interfaces where id=1";
        Processing processing = new Processing();
        Map<String,Object> param = processing.processData(sql);
        String url = processing.getUrl(sql);
        String  result = demo02.headerPost(url,header,param);
        System.out.println(result);

    }
}
