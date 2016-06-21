package aaaa;

public class Test
{
	public static void changeStr(String str,int[] a)
	{
		str = "welcome";
		a[1]=5;
}
	public static void main(String[] args)
{
		String str = "1234";
		int[] a={1,2};
		changeStr(str,a);
		System.out.println(str+a[1]);
		int k=12;
		int kk=k>>2;
		for(int i=0;i<5;i++)
			k+=1<<i;
		System.out.println(kk+"  "+k);
		}
}