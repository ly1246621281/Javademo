package aaaa;

import java.util.Arrays;
import java.util.Scanner;

public class LastLength {
	public static void solver(String str){
	
		String[] array;int i=0;
	/*	while((array[i]=str.split(""))!=null){
			i++;
		}*/
		array=str.split(" ");
		System.out.println(array.length);
		for(i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		System.out.println(Arrays.toString(array));
		String last=array[array.length-1];
		System.out.println(last+" "+last.length());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str="av v ddd";
		Scanner scan=new Scanner(System.in);
     	String str=scan.nextLine();
     	System.out.println(str);
		solver(str);
	}

}
