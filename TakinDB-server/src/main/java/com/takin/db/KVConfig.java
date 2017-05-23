package com.takin.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.takin.emmet.file.PropertiesHelper;
import com.takin.emmet.string.StringUtil;
import com.takin.emmet.util.PlatformUtils;

@Singleton
public class KVConfig {

    private static final Logger logger = LoggerFactory.getLogger(KVConfig.class);

    private int brokerid = -1;

    private String logdirs = "";

    private int numpartitions = 1;

    private int port;

    private boolean topicAutoCreated = true;

    private String hostname;

    private int maxmessagesize = 1048576;

    private int logfilesize;

    private int logflushintervalmessages = 100;

    private int logflushintervalms = 1000;

    private int logretentionhours = 12;

    private int logsegmentbytes = 1073741824;

    private int logCleanupIntervalms = 60 * 1000;

    private int logretentioncheckintervalms = 300000;

    private boolean usezk = false;

    private String zkhosts;

    private int zksessiontimeoutms = 600;

    private int zookeeperconnectiontimeoutms = 6000;

    @Inject
    private KVConfig() {
    }

    public void init(String filepath) {
        try {
            logger.info(filepath);
            PropertiesHelper prop = new PropertiesHelper(filepath);
            setBrokerid(prop.getInt("broker.id"));
            setLogdirs(prop.getString("log.dirs"));
            setLogfilesize(prop.getInt("log.file.size"));
            setLogflushintervalmessages(prop.getInt("log.flush.interval.messages"));
            setLogflushintervalms(prop.getInt("log.flush.interval.ms"));
            setLogretentioncheckintervalms(prop.getInt("log.retention.check.interval.ms"));
            setLogretentionhours(prop.getInt("log.retention.hours"));
            setLogsegmentbytes(prop.getInt("log.segment.bytes"));
            setNumpartitions(prop.getInt("num.partitions"));
            setUsezk(prop.getBoolean("zookeeper.use"));
            setZkhosts(prop.getString("zookeeper.connect"));
            setZksessiontimeoutms(prop.getInt("zk.sessiontimeout.ms"));
            setZookeeperconnectiontimeoutms(prop.getInt("zookeeper.connection.timeout.ms"));
            setMaxmessagesize(prop.getInt("max.message.size"));
            logger.info(JSON.toJSONString(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getLogCleanupIntervalms() {
        return logCleanupIntervalms;
    }

    public void setLogCleanupIntervalms(int logCleanupIntervalms) {
        this.logCleanupIntervalms = logCleanupIntervalms;
    }

    public int getMaxmessagesize() {
        return maxmessagesize;
    }

    public void setMaxmessagesize(int maxmessagesize) {
        this.maxmessagesize = maxmessagesize;
    }

    public int getBrokerid() {
        return brokerid;
    }

    public void setBrokerid(int brokerid) {
        this.brokerid = brokerid;
    }

    public String getLogdirs() {
        if (StringUtil.isNullOrEmpty(logdirs)) {
            if (PlatformUtils.isWindows()) {
                return "D:/takindb";
            } else {
                return "/home/takindb";
            }
        }
        return logdirs;
    }

    public boolean isTopicAutoCreated() {
        return topicAutoCreated;
    }

    public void setTopicAutoCreated(boolean topicAutoCreated) {
        this.topicAutoCreated = topicAutoCreated;
    }

    public void setLogdirs(String logdirs) {
        this.logdirs = logdirs;
    }

    public int getLogfilesize() {
        return logfilesize;
    }

    public void setLogfilesize(int logfilesize) {
        this.logfilesize = logfilesize;
    }

    public static Logger getLogger() {
        return logger;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getNumpartitions() {
        return numpartitions;
    }

    public void setNumpartitions(int numpartitions) {
        this.numpartitions = numpartitions;
    }

    public int getLogflushintervalmessages() {
        return logflushintervalmessages;
    }

    public void setLogflushintervalmessages(int logflushintervalmessages) {
        this.logflushintervalmessages = logflushintervalmessages;
    }

    public int getLogflushintervalms() {
        return logflushintervalms;
    }

    public void setLogflushintervalms(int logflushintervalms) {
        this.logflushintervalms = logflushintervalms;
    }

    public int getLogretentionhours() {
        return logretentionhours;
    }

    public void setLogretentionhours(int logretentionhours) {
        this.logretentionhours = logretentionhours;
    }

    public int getLogsegmentbytes() {
        return logsegmentbytes;
    }

    public void setLogsegmentbytes(int logsegmentbytes) {
        this.logsegmentbytes = logsegmentbytes;
    }

    public int getLogretentioncheckintervalms() {
        return logretentioncheckintervalms;
    }

    public void setLogretentioncheckintervalms(int logretentioncheckintervalms) {
        this.logretentioncheckintervalms = logretentioncheckintervalms;
    }

    public boolean isUsezk() {
        return usezk;
    }

    public void setUsezk(boolean usezk) {
        this.usezk = usezk;
    }

    public String getZkhosts() {
        return zkhosts;
    }

    public void setZkhosts(String zkhosts) {
        this.zkhosts = zkhosts;
    }

    public int getZksessiontimeoutms() {
        return zksessiontimeoutms;
    }

    public void setZksessiontimeoutms(int zksessiontimeoutms) {
        this.zksessiontimeoutms = zksessiontimeoutms;
    }

    public int getZookeeperconnectiontimeoutms() {
        return zookeeperconnectiontimeoutms;
    }

    public void setZookeeperconnectiontimeoutms(int zookeeperconnectiontimeoutms) {
        this.zookeeperconnectiontimeoutms = zookeeperconnectiontimeoutms;
    }

}
