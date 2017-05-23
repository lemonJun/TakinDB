package com.takin.db.client;

import com.takin.db.proxy.KVDBService;
import com.takin.rpc.client.ProxyFactory;

public class KVDBProvider {

    public static KVDBService getService() {
        KVDBService producer = ProxyFactory.create(KVDBService.class, "kvdb", null, null);
        return producer;
    }
}
