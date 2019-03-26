package demo1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/25.
 *
 */
public class testSuite {
    /**
     * 定时任务测试
     */
    public String url;
    public demo02 demo02;

    @BeforeTest
    public void setup(){
        url = "http://10.50.16.14:12001/job/addTaskData";
        demo02 = new demo02();
    }

    @Test
    public void testcase1() throws IOException {
        Map<String ,Object> header = new HashMap<String,Object>();
        header.put("Content-Type","application/x-www-form-urlencoded");
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("serviceId",31);
        param.put("ttime","0");
        param.put("data","180713170149NXq985298");
        String result = demo02.headerPost(url,header,param);
        System.out.println(result);
    }

}
