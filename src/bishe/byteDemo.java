package bishe;

public class byteDemo {
	public static void main(String[] args) {
		byte b=(byte)0x81;
		System.out.printf("%d=0x%x\n",b,b);
		char c=(char)(b&0xff);
		System.out.printf("%d=0x%02x\n",(int)c,(int)c);
		short s=(short)(b&0x00ff);
		System.out.printf("%d=0x%02x\n",s,s);
		int i=b&0x00ff;
		System.out.printf("%d=0x%02x\n",i,i);
	}
}
