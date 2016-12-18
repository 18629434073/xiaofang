package com.ht.util;

import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by chenh on 2016/8/10.
 */
public class RedisTest {

    private static Jedis node1;
    private static Jedis node2;
    private static Jedis node3;
    private static final int DEFAULT_TIMEOUT = 5000;
    private static final int DEFAULT_REDIRECTIONS = 10;
    private static final JedisPoolConfig DEFAULT_CONFIG = new JedisPoolConfig();

    public static void main(String[] args) throws InterruptedException, IOException {

        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("10.10.20.181", 7003));
        jedisClusterNode.add(new HostAndPort("10.10.20.180", 7000));
        jedisClusterNode.add(new HostAndPort("10.10.20.181", 7004));

        jedisClusterNode.add(new HostAndPort("10.10.20.180", 7001));
        jedisClusterNode.add(new HostAndPort("10.10.20.180", 7002));
        jedisClusterNode.add(new HostAndPort("10.10.20.181", 7005));

//        DEFAULT_CONFIG.
        JedisCluster jc = new JedisCluster(jedisClusterNode, DEFAULT_TIMEOUT, DEFAULT_TIMEOUT, DEFAULT_REDIRECTIONS, "htxa", DEFAULT_CONFIG);
//        jc.set("foo","hello?");
        System.out.println(jc.get("foo"));
//        Iterator<JedisPool> poolIterator = jc.getClusterNodes().values().iterator();
//        while (poolIterator.hasNext()) {
//            JedisPool pool = poolIterator.next();
//            try {
//                System.out.println("########"+pool.getResource());
//            } catch (JedisConnectionException e) {
//                e.printStackTrace();
//            }
//        }

        jc.close();

    }

    public static void cleanUp() {
        node1.flushDB();
        node2.flushDB();
        node3.flushDB();

        node1.clusterReset(JedisCluster.Reset.SOFT);
        node2.clusterReset(JedisCluster.Reset.SOFT);
        node3.clusterReset(JedisCluster.Reset.SOFT);

    }
}
