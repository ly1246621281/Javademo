package aaaa;

import java.util.Arrays;

 class yinyong {
	 
	
	public static void main(String[] args) {
	//	helloworld h=new helloworld();
		int[] array=new int[10];
		System.out.println(Arrays.toString(array)+array+"  "+array[0]);
		double d1=0.1;
		double d2=0.6;
		double d3=-0.1;
		double d4=-1.1;
		//ceil返回比此值大的整数，floor返回小的。可以反着来考虑
		System.out.println(Math.ceil(d1)+" "+Math.floor(d1));
		System.out.println(Math.ceil(d2)+" "+Math.floor(d2));
		System.out.println(Math.ceil(d3)+" "+Math.floor(d3));
		System.out.println(Math.ceil(d4)+" "+Math.floor(d4));
	
		Integer i1=92;
		Integer i2=Integer.valueOf(92);
		System.out.println(i1==i2);
		String s1="abc";
		String s2="abc".toString();
		String s3=String.valueOf("abc");
		System.out.println(s1==s3);
		if(true){
			byte b1=1,b2=2,b3,b5 = (byte) 0.0;
			short sh1=10;
			sh1=b2;
			//b3=sh1;
			b3=(byte) (b1*b2);
			int b4=b1+b2;//b3=(byte)b1+b2;
			System.out.println(b3+" "+sh1+" "+b5);
		}
	}

}
