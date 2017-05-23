package com.takin.db;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;

import com.google.common.util.concurrent.AbstractService;
import com.takin.db.store.KVStoreManager;
import com.takin.rpc.server.GuiceDI;
import com.takin.rpc.server.RPCServer;

public class KVBootstrap extends AbstractService {
    private static final RPCServer server = new RPCServer();

    private KVConfig config;

    public void init(String[] args, boolean online) {
        try {
            PropertyConfigurator.configure("conf/log4j.properties");
            server.init(new String[] {}, false);
            initBroker();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void initBroker() throws Exception {
        GuiceDI.init();
        config = GuiceDI.getInstance(KVConfig.class);
        config.init(server.getContext().getConfigPath() + File.separator + "kvdb.properties");
        //        
        GuiceDI.getInstance(KVStoreManager.class);
    }

    public void dostop() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            server.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doStart() {
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    protected void doStop() {

    }
}
