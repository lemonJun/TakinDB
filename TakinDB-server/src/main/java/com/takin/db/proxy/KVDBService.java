package com.takin.db.proxy;

import com.takin.rpc.server.anno.ServiceDefine;

@ServiceDefine
public interface KVDBService {

    /**
     * 插入一条数据
     * @param data
     * @return
     * @throws Exception
     */
    public abstract boolean insert(String key, String value) throws Exception;

}
