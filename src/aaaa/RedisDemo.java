package aaaa;
import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;
public class RedisDemo {
	

	   public static void main(String[] args) {
	      //连接本地的 Redis 服务
	      Jedis jedis = new Jedis("localhost");
	      System.out.println("Connection to server sucessfully");
	      //查看服务是否运行
	      System.out.println("Server is running: "+jedis.ping());
	 }
	   @Test
	   public void RedisString(){
		 //连接本地的 Redis 服务
		      Jedis jedis = new Jedis("localhost");
		      System.out.println("Connection to server sucessfully");
		      //设置 redis 字符串数据
		      jedis.set("w3ckey", "Redis tutorial");
		     // 获取存储的数据并输出
		     System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
		 }
	   @Test
	   public void RedisList(){
		 //连接本地的 Redis 服务
		      Jedis jedis = new Jedis("localhost");
		      System.out.println("Connection to server sucessfully");
		      //存储数据到列表中
		      jedis.lpush("tutorial-list", "Redis");
		      jedis.lpush("tutorial-list", "Mongodb");
		      jedis.lpush("tutorial-list", "Mysql");
		     // 获取存储的数据并输出
		     List<String> list = jedis.lrange("tutorial-list", 0 ,5);
		     for(int i=0; i<list.size(); i++) {
		       System.out.println("Stored string in redis:: "+list.get(i));
		     }
	   }
	   @Test
	   public void Rediskey(){
		 //连接本地的 Redis 服务
		      Jedis jedis = new Jedis("localhost");
		      System.out.println("Connection to server sucessfully");
		      
		     // 获取数据并输出
		     List<String> list =  (List<String>) jedis.keys("*");
		     for(int i=0; i<list.size(); i++) {
		       System.out.println("List of stored keys:: "+list.get(i));
		     }
	   }
	}