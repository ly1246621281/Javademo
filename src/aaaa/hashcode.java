package aaaa;

public class hashcode {
	
     /**
	 4  * 
	 5  * 
	 6  * String, StringBuffer 在传参过程中的哈希值比较
	 7  */
	public static void main(String[] args){
		String str="123w";
		String str1=new String("1234q");
		StringBuffer sb=new StringBuffer("123456e");
		System.out.println("str改变前："+str.hashCode());
		change(str);
		System.out.println(str+"\n\n"+str.hashCode());
		System.out.println("-------------------");
		System.out.println("str1改变前:"+str1.hashCode());
		change(str1);
		System.out.println(str1+"\n\n"+str1.hashCode());
		System.out.println("----------------");
		System.out.println("sb改变前:"+sb.hashCode());
		change(sb);
		System.out.println(sb+"\n\n"+sb.hashCode());
		
		Integer i=new Integer(54);
		System.out.println(i.hashCode());
		change(i);
		System.out.println(i+"\n\n"+i.hashCode());
	}
	public static void change(String str) {
		System.out.println("形参的哈希值：" + str.hashCode());
		str = "newString";//修改了形参的值
		System.out.println("修改后：" + str.hashCode());
		}
	public static void change(StringBuffer sb) {
		System.out.println("形参的哈希值：" + sb.hashCode());
		sb.append("newStringBuffer");//修改了形参的值
		System.out.println("修改后：" + sb.hashCode());
		}
	public static void change(Integer str) {
		System.out.println("形参的哈希值：" + str.hashCode());
		str = 540;//修改了形参的值
		System.out.println("修改后：" + str.hashCode());
		}
}
