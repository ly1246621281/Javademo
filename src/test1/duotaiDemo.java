package test1;
class father{
	public int i1=5;
	void fun1(){
		System.out.println("father fun1()");
	}
}
class son extends father{
	public int i1=10;
	public int i2=6;
	public void fun1(){
		System.out.println("son fun1()");
	}
	public void fun2(){
		
		System.out.println("son fun2()");
	}
}

public class duotaiDemo {
	public static void main(String[] args) {
		father f2=new father();
		f2.fun1();
		father f1;
		f1=new son();
		f1.fun1();
		System.out.println(f1.i1);

	}

}
