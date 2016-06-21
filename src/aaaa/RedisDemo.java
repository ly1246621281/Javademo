package aaaa;
import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;
public class RedisDemo {
	

	   public static void main(String[] args) {
	      //���ӱ��ص� Redis ����
	      Jedis jedis = new Jedis("localhost");
	      System.out.println("Connection to server sucessfully");
	      //�鿴�����Ƿ�����
	      System.out.println("Server is running: "+jedis.ping());
	 }
	   @Test
	   public void RedisString(){
		 //���ӱ��ص� Redis ����
		      Jedis jedis = new Jedis("localhost");
		      System.out.println("Connection to server sucessfully");
		      //���� redis �ַ�������
		      jedis.set("w3ckey", "Redis tutorial");
		     // ��ȡ�洢�����ݲ����
		     System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
		 }
	   @Test
	   public void RedisList(){
		 //���ӱ��ص� Redis ����
		      Jedis jedis = new Jedis("localhost");
		      System.out.println("Connection to server sucessfully");
		      //�洢���ݵ��б���
		      jedis.lpush("tutorial-list", "Redis");
		      jedis.lpush("tutorial-list", "Mongodb");
		      jedis.lpush("tutorial-list", "Mysql");
		     // ��ȡ�洢�����ݲ����
		     List<String> list = jedis.lrange("tutorial-list", 0 ,5);
		     for(int i=0; i<list.size(); i++) {
		       System.out.println("Stored string in redis:: "+list.get(i));
		     }
	   }
	   @Test
	   public void Rediskey(){
		 //���ӱ��ص� Redis ����
		      Jedis jedis = new Jedis("localhost");
		      System.out.println("Connection to server sucessfully");
		      
		     // ��ȡ���ݲ����
		     List<String> list =  (List<String>) jedis.keys("*");
		     for(int i=0; i<list.size(); i++) {
		       System.out.println("List of stored keys:: "+list.get(i));
		     }
	   }
	}