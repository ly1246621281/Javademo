package test1;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //while(true){
            int f = 0;
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()) {
        int n=sc.nextInt();
        int a=sc.nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=sc.nextInt();
        for(int i=0;i<n;i++){
            	
        	f=fun1(a,array[i]);
            a=f;
        }
            System.out.println(f);
       // }
        } 
    }
  
    public static int fun1(int a,int b){
       
        if(a>=b) a+=b;
        else {
            	int c=fun2(a,b);
  				a+=c;
        }
      return a;
    }
    public static int  fun2(int n1,int n2){
        if(n1%n2==0)
            return n2;
        int p=n1%n2;
        n1=n2;
        n2=p;
        return fun2(n1,n2);
    }
}