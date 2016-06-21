package aaaa;

public class enumdemo {
	public enum k{
		   spring(3),
		   summer(7),
		   autor(4),
		   winter(5);
		  private int value;
		 //默认枚举类型的构造函数是private修饰，而且必须是private。
		 //构造器是带参数的，上面的spring（3）才成立，相当于  enum k=new enum(3);
		 private k( int value){
			   this.value=value;
		   }
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		   
		}
	public static void main(String[] args) {
		k k1=k.valueOf(k.class, "summer");
		k k2=k.spring;
		//k.spring.ordinal 是最原始的位置值，要获得他的真实值，需要调用参数value
		System.out.println(k.spring.ordinal()+"  "+k.autor.getDeclaringClass());
		System.out.println(k1.value+" "+k2);
	}
}
