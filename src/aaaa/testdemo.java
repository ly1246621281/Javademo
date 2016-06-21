package aaaa;

abstract class BaseClass{
	final int i=01;
	int j=10;
	static{
		System.out.println("abstract");
	}
	BaseClass(){
		System.out.println("B0");
	}
	{
		System.out.println("ab");
	}
	abstract void out();
}

class FatherClass extends BaseClass{
	int i=0;
	int j=3;
	FatherClass(){
		System.out.println("F0");
	}
	void out(){
		System.out.println("hah'");
		System.out.println(i+" "+j);
	}
   static {
	System.out.println("F1");
	}
  {
	System.out.println("F2");
}
	
}
class ChildClass extends FatherClass{
	int i=3;
	int j=0;
	ChildClass(){
		System.out.println("C1");
	}
	void out(){
		System.out.println(i+" "+j);
	}
	static {
		System.out.println("C2");
	}
	{
		System.out.println("C3");
	}
	
}
public class testdemo {
	public static void main(String[] args) {
	    FatherClass s=new ChildClass();
	    s.out();
	    System.out.println(s.i+" "+s.j);
 	}

}
