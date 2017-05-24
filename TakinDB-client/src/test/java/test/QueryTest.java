package test;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.alibaba.fastjson.JSON;
import com.takin.db.client.KVDBProvider;
import com.takin.db.proxy.KVDBService;

public class QueryTest {

    public static void main(String[] args) {
        try {
            PropertyConfigurator.configure("conf/log4j.properties");
            final KVDBService producer = KVDBProvider.getService();
            List<String> values = producer.get("k59");
            System.out.println(JSON.toJSONString(values));
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
