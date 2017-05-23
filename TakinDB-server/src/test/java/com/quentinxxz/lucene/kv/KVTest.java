package com.quentinxxz.lucene.kv;

import com.takin.db.KVBootstrap;

public class KVTest {

    public static void main(String[] args) {
        KVBootstrap broker = new KVBootstrap();
        broker.init(new String[] {}, false);
        broker.startAsync().awaitRunning();
    }

}
