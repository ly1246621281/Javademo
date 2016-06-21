package test1;

import java.util.Scanner;

public class Paotai {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int count=0;int x0=0,x1=0,x2=0,x3=0,y0=0,y1=0,y2=0,y3=0,R=0,num1=0,num2=0,num3=0;
		while(sc.hasNextInt()){
			R=sc.nextInt();
			x1=sc.nextInt();
			y1=sc.nextInt();
			x2=sc.nextInt();
			y2=sc.nextInt();
			x3=sc.nextInt();
			y3=sc.nextInt();
			x0=sc.nextInt();
			y0=sc.nextInt();
			num1=pointtopoint(x1, y1, x0, y0);
			num2=pointtopoint(x2,y2,x0,y0);
				num3=pointtopoint(x3, y3, x0, y0);
			if(num1<=R)
				count++;
			if(num2<=R)
				count++;
			if(num3<=R)
				count++;
			System.out.println(count+"x");
		}
		
	}

	public static int  pointtopoint(int x1,int y1,int x2,int y2){
		int num;
		num=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		num=(int) Math.sqrt(num);
		return num;
		//Math.
	}

}
