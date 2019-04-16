package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2019/4/4.
 * 读取.properties文件
 * 该类主要是根据路径读取配置文件
 */
public class ReaderProperties {

    public Map<String,String> getPropertiest(String filename) throws Exception {
        Properties properties = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        properties.load(bufferedReader);
        String driver = properties.getProperty("jdbc.driver");
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        Map<String,String> params = new HashMap<String,String>();
        params.put("driver",driver);
        params.put("url",url);
        params.put("username",username);
        params.put("password",password);
        return  params;
    }
}
