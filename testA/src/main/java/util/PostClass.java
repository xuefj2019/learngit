package util;

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
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/12.
 */
public class PostClass {

    public CloseableHttpResponse response;
    public JSONObject jsonObject;
    public String result;
    public Processing processing;
    //有头信息的post方法

    /**
     * body为json串
     * @param url
     * @param header
     * @param param
     * @return
     * @throws Exception
     */
    public JSONObject postMethod(String url, Map<String,String> header, Map<String,Object> param) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        //请求头
        for(String key:header.keySet()){
            httpPost.setHeader(key,header.get(key));
        }

        //请求体
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        if(param != null && !param.isEmpty()){
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for(String key:param.keySet()){
                urlParameters.add(new BasicNameValuePair(key, param.get(key).toString()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(urlParameters, HTTP.UTF_8));
        }
        response = httpClient.execute(httpPost);

        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity,"UTF-8");

        jsonObject = new JSONObject(result);

//        System.out.println(response.getStatusLine());
        //断言
        return jsonObject;

    }
    /**
     * 请求参数为key value格式
     */

    public JSONObject postMethodKV(String url,Map<String,String> header, Map<String,Object> param) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        //请求头
        for(String key:header.keySet()){
            httpPost.setHeader(key,header.get(key));
        }

        //请求体
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        if(param != null && !param.isEmpty()){
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for(String key:param.keySet()){
                urlParameters.add(new BasicNameValuePair(key, param.get(key).toString()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(urlParameters, HTTP.UTF_8));
        }


        response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity,"utf-8");

        jsonObject = new JSONObject(result);
        return jsonObject;
    }



    /**
     * get方法
     * @return
     */
    public void getMethod(){

    }




    //获得状态码
    public int getCode(){
        int status = response.getStatusLine().getStatusCode();
        return status;
    }

    //获得字符串类型的结果
    public String getResult() throws IOException {
        return result;
    }


//    //如果是post方法，如果是get方法
//    String method = processing.getMethod(sql);


}
