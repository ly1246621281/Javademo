package Memcached;

import java.util.Date;

import org.junit.Test;

public class MemcachedTimeTest {

	private MemcachedHelper install = MemcachedHelper.getInstance();

	private String key = "YE1000";

	@Test
	public void testAdd() {
		String value = "这是一个Demo测试案例！";
		install.add(key, value, new Date(1000 * 50));
		install.add(key+"_01",value) ;
		System.out.println(install.get(key)+"\n"+install.get(key+"_01"));
	}

	@Test
	public void testSet() {
		String value = "这是一个Demo测试案例！set如有则替换";
		//install.set(key, value, new Date(1000 * 50));
		System.out.println(install.get(key)+"\n"+install.get(key+"_01"));
	}

	@Test
	public void testGet() {
		String value = (String) install.get(key+"_01");
		System.out.println(value);
	}

	@Test
	public void testDelete() {
		install.delete(key+"_01");
	}

	@Test
	public void testKeyExists() {
		System.out.println(install.keyExists(key));
	}
}