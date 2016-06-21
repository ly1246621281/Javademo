package test1;

import java.util.ArrayList;
import java.util.List;



public class J数组中重复元素最多 {
	
	public static void main(String[] args) {
		int a[]={1,1,2,2,2,3,4,4,4,4,5,5,6,6,6};
		serve(a);
		
	}
	public static void serve(int[] a){
		int[] c=new int[10];
		int[] d=new int[10];
		int count=0;
		for(int i=0;i<a.length;i++)
			{
				boolean biaozhi = false;
				for(int j=0;j<c.length;j++)
					if(a[i]==c[j])
						{
							d[j]++;
							biaozhi=true;
						}
				if(biaozhi==false)
					{
						
						c[count]=a[i];
						d[count]=1;
						count++;
					}
				
			}
		//printf(c,d);
		maxfun(d, c);
	}
	public static void printf(int[] c,int[] d){
		int count=0;
		for(int num:c){
			System.out.println("c["+count+++"]="+num);
		}
		count=0;
		for(int num:d){
			System.out.println("d["+count+++"]="+num);
		}
		
	}
	public static void maxfun(int[] d,int[] c){
		int max=d[0];int count=0;
		for(int i=0;i<d.length;i++)
		{
			//max=d[i];
			if(max<d[i])
				{
					max=d[i];
					count=i;
				}
		System.out.println(max +"  "+count);	
		}
		System.out.println(max+ " " +c[count]);
	}
}
