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
    @Test(groups = "index",description = "首页测试")
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

    @Test(groups = "taodada",description = "首页接口")
    public void index() throws IOException {
        Map<String,Object> header = new HashMap<String,Object>();
        header.put("Content-type","text/html; charset=UTF-8");

        Map<String,Object> param = new HashMap<String,Object>();
        param.put("timestamp",1554084365);
        param.put("strategy","123df9mcfdaf");
        param.put("sign","3A93C7773D672B6A8A503CE83A0FC26E");
        param.put("page",1);
        param.put("query","{\"columns\":2,\"function\":\"taodada\",\"has_header\":0,\"module\":\"99\",\"only_product\":1,\"page\":1,\"static_id\":1003}");
        param.put("client","{\"ageGroup\":\"ALL\",\"channel\":\"QD_yyb\",\"deviceBrand\":\"OPPO OPPO R9m\",\"deviceId\":\"e71bd653dc2fe81eb6cd3b6984e5b189\",\"gender\":\"0\",\"imei\":\"863048031850535\",\"net\":\"wifi\",\"packageName\":\"com.culiukeji.huanletao\",\"platform\":\"android\",\"screen\":\"1920*1080\",\"sdkVersion\":\"5.1\",\"sessionId\":\"c3a92b26e8245799e168f1b2da537e33\",\"shopToken\":\"\",\"userId\":\"0\",\"version\":\"3.32.147\",\"xingeToken\":\"\"}");
        String result = demo.headerPost(host,header,param);
        System.out.println(result);

    }

    @Test(groups = "loginTest")
    public void loginByPhone() throws IOException {
        String path = "http://master.api-passport.chuchujie.com/api.php";
        Map<String,Object> header = new HashMap<String,Object>();
        header.put("Content-type","text/html; charset=UTF-8");

        Map<String,Object> param = new HashMap<String,Object>();
        param.put("data","{\"api_version\":\"1.1\",\"channel\":\"QD_yyb\",\"client_type\":\"android\",\"client_version\":\"3.32.147\",\"deviceBrand\":\"OPPO OPPO R9m\",\"deviceId\":\"e71bd653dc2fe81eb6cd3b6984e5b189\",\"gender\":\"0\",\"imei\":\"863048031850535\",\"is_relevance_list\":\"1\",\"method\":\"login_by_phone\",\"net\":\"wifi\",\"package_name\":\"com.culiukeji.huanletao\",\"password\":\"36bdd4f956a5246c1efee5b87de0e231\",\"phone_number\":\"15901459014\",\"screen\":\"1920*1080\",\"sdkVersion\":\"5.1\",\"series_number\":\"XkQVb3\",\"sessionId\":\"c3a92b26e8245799e168f1b2da537e33\",\"sign\":\"4B8FB06D17FA13F333BE2CDEEEEA6508\",\"sms_code\":\"\",\"timeStamp\":1554087918094,\"token\":\"\",\"update_verify_flag\":0,\"userId\":\"0\",\"verify_code\":\"\",\"xingeToken\":\"\"}");

        System.out.println(param.values());
        String result = demo.headerPost(path,header,param);
        System.out.println(result);
    }


    @Test(groups = "loginTest",description = "登录接口",enabled = false)
    public void LoginInterfaceName() throws IOException {
        String url = "http://master.api.chuchujie.com/api/?v=2.0";
        Map<String,Object> header = new HashMap<String,Object>();
        header.put("Content-type","text/html; charset=UTF-8");

        Map<String,Object> param = new HashMap<String,Object>();
        param.put("data","{\"api_version\":\"1.1\",\"channel\":\"QD_yyb\",\"client_type\":\"android\",\"client_version\":\"3.32.147\",\"deviceBrand\":\"OPPO OPPO R9m\",\"deviceId\":\"e71bd653dc2fe81eb6cd3b6984e5b189\",\"gender\":\"0\",\"imei\":\"863048031850535\",\"is_relevance_list\":\"1\",\"method\":\"login_by_phone\",\"net\":\"wifi\",\"package_name\":\"com.culiukeji.huanletao\",\"password\":\"36bdd4f956a5246c1efee5b87de0e231\",\"phone_number\":\"15901459014\",\"screen\":\"1920*1080\",\"sdkVersion\":\"5.1\",\"series_number\":\"6Rex9H\",\"sessionId\":\"c3a92b26e8245799e168f1b2da537e33\",\"sign\":\"6E9585DD872B22F242054DE3D8A7A799\",\"sms_code\":\"568189\",\"timeStamp\":1554083358816,\"token\":\"\",\"update_verify_flag\":0,\"userId\":\"0\",\"verify_code\":\"11\",\"xingeToken\":\"\"}");
        String result = demo.headerPost(url,header,param);
        System.out.println(result);
    }
}
