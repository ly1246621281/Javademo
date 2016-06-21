package test1;

import java.util.Arrays;

public class Jquick {

	/*
	 * 选择排序：
	 * 1.比较次数同冒泡排序还是n*(n-1)/2
	 * 2.交换次数不再是比较次数的一半了，而是O(N)
	 * 插入排序：
	 * 1.时间复杂度还是O(n)
	 * 2.但是比冒泡快一倍，比选择Kauai。
	 */
	
	public static void Jchoose(int[] a){
		int count=0;
		for(int i=0;i<a.length;i++)
			for(int j=i;j<a.length;j++)
				if(a[i]>a[j])
				{
					int min;
					min=a[j];
					a[j]=a[i];
					a[i]=min;
					count++;
				}
		for(int p:a)
		System.out.println(p);
		System.out.println("count="+count);
	}
	
	public static void Jmaopao(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] < a[j + 1]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
					count++;
				}
				System.out.println(Arrays.toString(a));
			}
		}
		System.out.println("count=" + count);
	}
	static public void Jinsert(int[] a){
		for(int i=1;i<a.length;i++)
		{
			int temp=a[i];//待插元素
			int j=i-1;
			while(j>=0&&a[j]<temp)
			{
				a[j]=a[j-1];//为插入元素往后挪一个位置
				j--;
			}
			a[j+1]=temp;//为弥补上j--，所以j+1
		}
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a=new int[6];
		int a[]={1,4,3,5,7,2};
		Jchoose(a);
		Jmaopao(a);
		Jinsert(a);
	}
}
