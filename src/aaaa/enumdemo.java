package aaaa;

public class enumdemo {
	public enum k{
		   spring(3),
		   summer(7),
		   autor(4),
		   winter(5);
		  private int value;
		 //Ĭ��ö�����͵Ĺ��캯����private���Σ����ұ�����private��
		 //�������Ǵ������ģ������spring��3���ų������൱��  enum k=new enum(3);
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
		//k.spring.ordinal ����ԭʼ��λ��ֵ��Ҫ���������ʵֵ����Ҫ���ò���value
		System.out.println(k.spring.ordinal()+"  "+k.autor.getDeclaringClass());
		System.out.println(k1.value+" "+k2);
	}
}
