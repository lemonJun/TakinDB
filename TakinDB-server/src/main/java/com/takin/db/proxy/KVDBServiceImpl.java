package com.takin.db.proxy;

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

}
