package bishe;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class switchDemo {
	public static void main(String[] args) {
		int d=1;
		switch(d){
		case 1:
			{System.out.println("1111");
			
			System.out.println();}
		case 2:
			System.out.println("2222");
			break;
		case 3:
			System.out.println("3333");
		}
	}
	@Test
	public void map(){
		Map map=new HashMap();
		map.put("1", "1111");
		map.put("a", "aaaa");
		Set<String> sett=map.keySet();
		for(String key:sett){
//			System.out.println(key+"  "+map.get(key));
		}
		Collection<String> set=map.values();
		set.remove(map.get("a"));
		System.out.println(set);
		
		for(String value:set){
			System.out.println(value);
		}
	}
	@Test
	public void nullTest(){
		Object s=null;
		String str="d";
		System.out.println(s+str);
	}
}
