package com.gecco.atest.redis;

import redis.clients.jedis.Jedis;

public class Tredis {

	public static void main(String[] args) {

		Jedis jedis = RedisUtil.getJedis();
		
		System.out.println(jedis.get("a"));
	}

}
