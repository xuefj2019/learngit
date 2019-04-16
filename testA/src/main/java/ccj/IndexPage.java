package ccj;

import org.json.JSONObject;
import org.testng.annotations.Test;
import util.AssertClass;
import util.PostClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/16.
 */
public class IndexPage {


    @Test
    public void test01() throws IOException {
        String url = "http://master.api.chuchujie.com/api/?v=2.0";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("timestamp","1555405055");
        param.put("strategy","123df9mcfdaf");
        param.put("sign","006BF343265D665448E3B300702F0666");
        param.put("query","{\"function\":\"dynamic\",\"module\":\"settings\"}");
        param.put("client","{\"ageGroup\":\"ALL\",\"channel\":\"QD_yyb\",\"deviceBrand\":\"OPPO OPPO R9m\",\"deviceId\":\"e71bd653dc2fe81eb6cd3b6984e5b189\",\"gender\":\"0\",\"imei\":\"863048031850535\",\"net\":\"wifi\",\"packageName\":\"com.culiukeji.huanletao\",\"platform\":\"android\",\"screen\":\"1920*1080\",\"sdkVersion\":\"5.1\",\"sessionId\":\"e4827ca57eeb0de72ca2187a81d8887f\",\"shopToken\":\"\",\"userId\":\"0\",\"version\":\"3.32.147\",\"xingeToken\":\"\"}");
        param.put("version","33");

        Map<String,String> header = new HashMap<>();
        header.put("Content-Type","application/x-www-form-urlencoded");
        PostClass postClass = new PostClass();
        JSONObject jsonObject = postClass.postMethodKV(url,header,param);
        System.out.println(jsonObject.getJSONObject("debug").getJSONObject("functions").get("fileCacheRate"));

        int rate = (int)jsonObject.getJSONObject("debug").getJSONObject("functions").get("fileCacheRate");
        AssertClass assertClass = new AssertClass();
        assertClass.assertStatusMethod(rate,100);

    }

}
