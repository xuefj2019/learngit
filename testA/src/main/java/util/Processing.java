package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/4.
 * 该类主要是获得data值和url值
 */
public class Processing {

    public  ConnectMysql connectMysql = new ConnectMysql();
    public  String method = null;
    public  ResultSet resultSet;
//    public void init(){
//        ConnectMysql connectMysql = new ConnectMysql();
//    }


    public Map<String,Object> processData(String sql) throws Exception {
//        String sql=null;
        resultSet = connectMysql.getConnect(sql);
        Object data = null;
        while (resultSet.next()){
            data = resultSet.getString("data");
        }
        System.out.println(data);
        Map<String ,Object> param = new HashMap<String,Object>();
        param.put("data",data);
        return param;
    }

    public String getUrl(String sql) throws Exception {
        resultSet = connectMysql.getConnect(sql);
        String url = null;
        while (resultSet.next()){
            url = resultSet.getString("url");
        }
        return url;
    }


    public String getMethod(String sql) throws Exception {
        resultSet = connectMysql.getConnect(sql);
        String method = null;
        while (resultSet.next()){
            method = resultSet.getString("method");
        }
        return method;
    }
}
