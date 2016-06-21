package aaaa;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.Test;

public class bytedemo {
	public static void main(String[] args) {
		byte[] by=new byte[]{0x00,0x12};
		System.out.println(by.toString());
		char[] char1=new char[]{'f','a'};
		for(byte b:by){
			System.out.println(String.valueOf(b));
			System.out.println(String.valueOf(new char[]{'f','a'})+Integer.toBinaryString(b));
		}
		System.out.println(stomac("12-34-45-56-78-89")[1]+"   "+Arrays.toString(by));
		System.out.println("=================");
		String  str="";
		char[] ch="123456".toCharArray();
		byte[] byte1="12345".getBytes();
		System.out.println("byte1=="+Arrays.toString(byte1));
		for(char c:ch){
			str+=Integer.toUnsignedString(c, 2)+"-";
		}
		System.out.println(str);
	}
	public static byte[] stomac(String str) {
		byte[] mac = new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 };
		String[] temp = str.split("-");
		for (int x = 0; x < temp.length; x++) {
		mac[x] = (byte) ((Integer.parseInt(temp[x], 16)) & 0xff);
		System.out.println(mac[x]);
		}
		return mac;
		}
	@Test
	public void test_static_block(){
		String str=" ";
		int num;
		{
			num=9;
			String st="df";
		}
		if(num==9){
			String strr="df";
		}
		str="woqu";
		//strr="";
		System.out.println(str+num);
	}
	
}
