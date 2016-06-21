package test1;

public class stack_heap {
	static{
		System.out.println("f");
	}
	public static void main(String[] args) {
		char[] a={'a','b','c'};
		
		String str0=new String("abc");
		String str1=new String(a);
		String str="abc";
		String str2="abc";
		int str_a=System.identityHashCode(str);
		/* str="ac1";
		 int str_ar= System.identityHashCode(str);*/
		int str1_a=System.identityHashCode(str1);
		int str0_a=System.identityHashCode(str0);
		if(str.equals(str1))
			System.out.println("value same");
		if(str0==str1)
			System.out.println("address same");
		if(str2==str0)
			System.out.println("   fsd ");
			System.out.println(str_a+"\n"+str1_a+"\n"+str0_a);
	}
}
