package aaaa;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
      /*  Scanner scan1=new Scanner(System.in);
        String str1=scan1.nextLine();
        //Scanner new Scanner(System.in);
        String cha1=scan1.next();
        String[] array=str1.toUpperCase().split(cha1.toUpperCase());
        if((str1.toUpperCase().charAt(str1.length()-1))==(cha1.toUpperCase().charAt(0)))
            System.out.println(array.length);
        else
            System.out.println(array.length-1);*/
        /*String str="abBA";
        char[] ch=str.toUpperCase().toCharArray();
        System.out.println(ch[1]+"'"+ch.length+" "+str.length()+"/n"+"\n"+"a");*/
        byte[] ip=stoip("172.16.69.157");
        for(byte i:ip)
        System.out.println("ip=="+(i&0xff));
        System.out.println((byte)(172&0xff));
    }

	public static byte[] stoip(String str){
		byte[] ip=new byte[]{0x0,0x0,0x0,0x0};
		String[] temp= str.split("\\.");
//		System.out.println("length");
		for(int x=0;x<temp.length;x++){
			System.out.println(x+"---"+temp[x]);
			ip[x]=(byte)(Integer.parseInt(temp[x])&0xff);
		}
		return ip;
	}
}