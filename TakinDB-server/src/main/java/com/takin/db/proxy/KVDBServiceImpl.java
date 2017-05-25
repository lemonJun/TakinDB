package com.takin.db.proxy;

import java.util.List;

import com.takin.db.store.KVStoreManager;
import com.takin.rpc.server.GuiceDI;
import com.takin.rpc.server.anno.ServiceImpl;

@ServiceImpl
public class KVDBServiceImpl implements KVDBService {

    @Override
    public boolean insert(String key, String value) throws Exception {
        KVStoreManager store = GuiceDI.getInstance(KVStoreManager.class);
        return store.insert(key, value);
    }

    @Override
    public List<String> get(String key) throws Exception {
        KVStoreManager store = GuiceDI.getInstance(KVStoreManager.class);
        return store.get(key);
    }

    @Override
    public List<String> lt(String key) throws Exception {
        return null;
    }

}
