package test1;

import java.util.Arrays;

public class JÑ­»·ÓÒÒÆ {
	public static void move(int[] a,int k){
		int i=0;
		int[] b=new int[k];
		for(i=k;i>0;i--)
			b[k-i]=a[a.length-i];
		for(i=1;i<=a.length-k;i++)
			{
				int temp=a[a.length-k-i];
				a[a.length-k-i]=a[a.length-i];
				a[a.length-i]=temp;
			}
		for(i=0;i<k;i++)
			a[i]=b[i];
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,3,4,5,6,6,7};
		move(a,4);
	}

}
