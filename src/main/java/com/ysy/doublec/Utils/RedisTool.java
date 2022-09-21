package com.ysy.doublec.Utils;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Repository
public class RedisTool {
    private RedisClient redisClient;
    private StatefulRedisConnection<String, String> conn;

    public RedisTool() {
        RedisURI redisUri = RedisURI.builder()
                .withHost("101.35.188.205")
                .withDatabase(0)
                .withPort(6379)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();
        //创建RedisClient
        redisClient = RedisClient.create(redisUri);
        //获取StatefulRedisConnection
        conn = redisClient.connect();
    }

    public void setContent(String key, String content, int time) {
        StatefulRedisConnection<String, String> conn = redisClient.connect();
        //创建同步模式的RedisCommands
        RedisCommands<String, String> redisCommands = conn.sync();
        //设置超时时长
        SetArgs setArgs = SetArgs.Builder.nx().ex(time);
        //执行Set命令
        redisCommands.set(key, content, setArgs);
    }

    public String getContent(String key) {
        StatefulRedisConnection<String, String> conn = redisClient.connect();
        //创建同步模式的RedisCommands
        RedisCommands<String, String> redisCommands = conn.sync();
        //执行Set命令
        String result = redisCommands.get(key);
        return result;
    }

    public void closeResource() {
        //关闭StatefulRedisConnection
        conn.close();
        //关闭RedisClient
        redisClient.shutdown();
    }
}
