package passport;

import demo1.demo02;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/28.
 *
 */
public class PassportModel {

    //全局变量
    public demo02 demo;
//    public String path;
    public String host ;

    @BeforeTest
    public void setup(){
        demo = new demo02();
        host = "http://master.api-passport.chuchujie.com";

    }

    /**
     * 用户模块system_sync接口
     */
    @Test
    public  void system_syncTest() throws IOException {
        String path = "/api.php?method=system_sync";
        //头信息
        Map<String,Object> header = new HashMap<String,Object>();
        header.put("Content-type","text/html; charset=UTF-8");
        //参数值
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("data","{\"channel\":\"QD_yyb\",\"client_type\":\"android\",\"client_version\":\"3.32.147\",\"deviceBrand\":\"OPPO OPPO R9m\",\"deviceId\":\"e71bd653dc2fe81eb6cd3b6984e5b189\",\"gender\":\"1\",\"imei\":\"863048031850535\",\"is_relevance_list\":\"1\",\"method\":\"system_sync\",\"net\":\"wifi\",\"package_name\":\"com.culiukeji.huanletao\",\"screen\":\"1920*1080\",\"sdkVersion\":\"5.1\",\"sessionId\":\"cb6f84ac6bf1120504d0e2bb3a75aad0\",\"sign\":\"774F340403D7740CA873BA809D42B64C\",\"timeStamp\":1553754382589,\"token\":\"dev031579771608669000070086568721579771608\",\"userId\":\"70086568\",\"xingeToken\":\"\"}");
        String url = this.host + path ;
        System.out.println(url);

        String result = demo.headerPost(url,header,param);

        //做断言
        System.out.println(result);
        //测试结果转为json格式
        JSONObject jsonObject = new JSONObject(result);
        int status = (int)jsonObject.get("status");
        Assert.assertEquals(status,70);

        System.out.println(status);
    }

}
