package demo1;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2019/3/25.
 */
public class demo02 {
    /**
     * 带有参数和头信息的post请求
     * @param url
     * @param headers
     * @param param
     * @return
     * @throws IOException
     */

    public String headerPost(String url,Map<String, Object> headers,Map<String,Object> param) throws IOException {
        //httpclient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //httppost
        HttpPost httpPost = new HttpPost(url);
        //返回包含键的视图
        Set<String> keys = headers.keySet();
        for(String key:keys){
            httpPost.setHeader(key,headers.get(key).toString());
        }

        //参数
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();


        if(param != null && !param.isEmpty()){
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for(String key:param.keySet()){
                urlParameters.add(new BasicNameValuePair(key, param.get(key).toString()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(urlParameters, HTTP.UTF_8));
        }

        //响应
        CloseableHttpResponse response = null;
        response = httpClient.execute(httpPost);
        HttpEntity entity = null;
        entity = response.getEntity();
        String result = EntityUtils.toString(entity,"UTF-8");
//        System.out.println(result);
        return result;
    }
}
