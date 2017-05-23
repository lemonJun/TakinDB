package test;

import com.takin.db.KVBootstrap;

public class KVDBTest {

    public static void main(String[] args) {
        KVBootstrap broker = new KVBootstrap();
        broker.init(new String[] {}, false);
        broker.startAsync().awaitRunning();
    }
}
