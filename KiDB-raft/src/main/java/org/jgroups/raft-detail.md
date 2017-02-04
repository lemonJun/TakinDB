###raft

see  http://thesecretlivesofdata.com/raft/ 

##角色
1. follower,刚启动时所有节点都为此状态，响应LEADER的日志同步请求，响应CANDIDATE请求，把请求到FOLLOwmhER的事务转发给LEADER; 
2. candidate,由follower转化而来，然后立即发起先举，成为leader后，变为leader状态；
3. leader,负责日志的同步管理，处理来自客户端的请求，与follower保持着心跳；

##Term
一个选举周期，连续递增的编号，每一轮的选举都是一个Term周期，在一个Term中只能产生一个leader；可以这么说每次Term递都都将发生新一轮
选举，RAFT保证一个Term中只有一个leader,在正常运转中所有的term都是一致的，如果节点不发生故障一个Term会一直保持下去 ；

##选举
完全由定时器来触发，且每个节点的定时器都不一样，这样就能保证