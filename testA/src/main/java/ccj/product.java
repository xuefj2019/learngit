package ccj;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/12.
 * 商品接口测试
 * maven  reimport
 */
public class product {


    public  String url;
    public  ConnectMysql connectMysql;
    public Processing processing;
    public PostClass postClass;
    public AssertClass assertClass;
    @BeforeTest
    public void init(){
        url = "http://master.api-product.chuchujie.com/api.php";
        connectMysql = new ConnectMysql();
        processing = new Processing();
        postClass = new PostClass();
        assertClass = new AssertClass();
    }


    @Test(enabled = false)
    public void check_colls_has_newp_Test01() throws Exception {
        //没有公共方法
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        //拼接字符串  测试用例
        String sql = "SELECT * from interfaces where interfacename = "+"'"+"check_colls_has_newp"+"'";

        Object data = null;
        Map<String,Object> param = processing.processData(sql);
        //从数据库取到body值
//        ResultSet resultSet = connectMysql.getConnect(sql);
//        while (resultSet.next()){
//            data = resultSet.getString("data");
//        }

        //body处理
//        Map<String,Object> param = new HashMap<String, Object>();
//        param.put("data",data);

        //请求头
        Map<String,String> header = new HashMap<String, String>();
        header.put("Content-Type","application/x-www-form-urlencoded");

        for(String key :header.keySet()){
            httpPost.setHeader(key,header.get(key));
        }

        //参数
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        //请求参数参数体
        if(param != null && !param.isEmpty()){
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for(String key:param.keySet()){
                urlParameters.add(new BasicNameValuePair(key, param.get(key).toString()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(urlParameters, HTTP.UTF_8));
        }
        System.out.println(urlParameters);
        CloseableHttpResponse response = httpClient.execute(httpPost);

        System.out.println(response.getStatusLine().getStatusCode());

        HttpEntity entity = response.getEntity();
        String  result = EntityUtils.toString(entity,"utf-8");
        System.out.println(result);
    }

    @Test(enabled = true)
    public void check_colls_has_newp_Test02() throws Exception {
        //第一步，测试用例sql
        String sql = "SELECT * from interfaces where interfacename = "+"'"+"check_colls_has_newp"+"'";
        //第二步，对查询到的用例进行处理，获得url,body

        Map<String,Object> param = processing.processData(sql);
        String  url = processing.getUrl(sql);
        Map<String,String> header = new HashMap<>();

        //第三步，提交请求

        JSONObject jsonObject = postClass.postMethod(url,header,param);
        System.out.println(postClass.getResult());
        System.out.println(jsonObject.get("data"));

//        JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
//        System.out.println(jsonObject1.get("last_update_time"));


        //JSONObject.getJSONObject("")获得json内层对象
        System.out.println(jsonObject.getJSONObject("data").get("last_update_time"));
        //第四步，断言，去结果中的某些字段值
        int status = (int)jsonObject.get("status");
        assertClass.assertStatusMethod(status,0);

        int last_update_time =(int)jsonObject.getJSONObject("data").get("last_update_time");
        assertClass.assertStatusMethod(last_update_time,0);
        //断言，响应状态码
        assertClass.assertStatusMethod(200);
    }


    /**
     * if method== post
     */
    @Test
    public void check_colls_has_newp_Test03() throws Exception {

        //第一步，测试用例sql
        String sql = "SELECT * from interfaces where interfacename = "+"'"+"check_colls_has_newp"+"'";
        //第二步，对查询到的用例进行处理，获得url,body


        Map<String,Object> param = processing.processData(sql);
        String  url = processing.getUrl(sql);
        Map<String,String> header = new HashMap<>();

        //第三步，提交请求
        JSONObject jsonObject = null;
        String method = processing.getMethod(sql);
        System.out.println(method);
        if(method.equals("post")){
            jsonObject = postClass.postMethod(url,header,param);
        }
        else {
            System.out.println("测试方法不符合");
        }
        System.out.println(postClass.getResult());
        System.out.println(jsonObject.get("data"));

//        JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
//        System.out.println(jsonObject1.get("last_update_time"));


        //JSONObject.getJSONObject("")获得json内层对象
        System.out.println(jsonObject.getJSONObject("data").get("last_update_time"));
        //第四步，断言，去结果中的某些字段值
        int status = (int)jsonObject.get("status");
        assertClass.assertStatusMethod(status,0);

        int last_update_time =(int)jsonObject.getJSONObject("data").get("last_update_time");
        assertClass.assertStatusMethod(last_update_time,0);
        //断言，响应状态码
        assertClass.assertStatusMethod(200);

    }


    /**
     * 插入数据
     */
    @Test
    public void insertTest() throws Exception {
        String sql = "insert into interfaces(interfacename,method,data,url,header) values(?,?,?,?,?)";
        Connection connection = ConnectMysql.getConn();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        InterfaceClass interfaceClass = new InterfaceClass("system_sync","post","http://master.api-passport.chuchujie.com/api.php?method=system_sync","header","{\"channel\":\"QD_yyb\",\"client_type\":\"android\",\"client_version\":\"3.32.147\",\"deviceBrand\":\"OPPO OPPO R9m\",\"deviceId\":\"e71bd653dc2fe81eb6cd3b6984e5b189\",\"gender\":\"0\",\"imei\":\"863048031850535\",\"is_relevance_list\":\"1\",\"method\":\"system_sync\",\"net\":\"wifi\",\"package_name\":\"com.culiukeji.huanletao\",\"screen\":\"1920*1080\",\"sdkVersion\":\"5.1\",\"sessionId\":\"5d377c332907bff0a66d8e6758005d0f\",\"sign\":\"F23A9BBF07DBE4D103DF2D288A0F7252\",\"timeStamp\":1555309753751,\"token\":\"\",\"userId\":\"0\",\"xingeToken\":\"\"}");

        preparedStatement.setString(1,interfaceClass.getInterfacename());
        preparedStatement.setString(2,interfaceClass.getMethod());
        preparedStatement.setString(3,interfaceClass.getData());
        preparedStatement.setString(4,interfaceClass.getUrl());
        preparedStatement.setString(5,interfaceClass.getHeader());

        preparedStatement.executeUpdate();
        connection.close();
        System.out.println("插入数据成功");

    }


    public void quickMethod(int[] arr,int i,int j){
        int x ;
        x = arr[i];
        while(i<j){
            while (i<j && arr[j]>x)
                j--;
            if(i<j)
                arr[i++]=arr[j];
            while(i<j && arr[i]<x)
                i++;
            if(i<j)
                arr[j--]=arr[i];

        }
        arr[i]=x;



    }
}
