package com.takin.db.proxy;

import java.util.List;

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

    public abstract List<String> get(String key) throws Exception;

    public abstract List<String> lt(String key) throws Exception;

}
