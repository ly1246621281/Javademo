package aaaa;

public class testdemo01 extends Test{
    public static void change(String str,int i){
    	str+="welcome";
    	i=i++;
    }
    public static void changeO(ObjectClass object){
    	object=new ObjectClass("welcome");
    	//object.value="where";
    }
    public static void main(String[] args) {
		/*String str="123 ";
		Integer i=new Integer(100);
		change(str,i);
		System.out.println("StringValue:"+str+i);
		String str1=new String("woshizhangkai");
		change(str1,i);
		System.out.println(str1);*/
    	/*int i=100;
		String sb=new String("woshi");
		change(sb,i);
		System.out.println(sb.toString()+i);
		
		String str="hhh";
		ObjectClass object=new ObjectClass(str);
		changeO(object);
		System.out.println("ObjectValue:" + object.value);*/
    	String str1="123456";
    	String str2="12345";
    	System.out.println(str1.compareTo(str2));
    	System.out.println(Integer.parseInt("123456",8));
    	
	}
    public static void changeStr(String str,int[] i){}
	
}

class ObjectClass {
	String value = null;

	public ObjectClass(final String value) {
		this.value = value;
	}
}