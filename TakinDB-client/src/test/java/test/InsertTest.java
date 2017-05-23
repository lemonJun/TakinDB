package test;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.PropertyConfigurator;

import com.google.common.util.concurrent.RateLimiter;
import com.takin.db.client.KVDBProvider;
import com.takin.db.proxy.KVDBService;

public class InsertTest {

    private static final RateLimiter limit = RateLimiter.create(100d);

    private static final AtomicInteger total = new AtomicInteger(8972);

    public static void main(String[] args) {
        try {
            PropertyConfigurator.configure("conf/log4j.properties");
            final KVDBService producer = KVDBProvider.getService();
            while (true) {
                if (limit.tryAcquire()) {
                    producer.insert("k" + total.getAndIncrement(), "v" + System.currentTimeMillis());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
