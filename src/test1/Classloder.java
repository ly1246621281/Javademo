package test1;

import javax.print.DocFlavor.URL;



class f1{
	static int p=0;
}
public class Classloder {
	
	static{
		i=2;
	}
    static int i=1;
	public static void main(String[] args) throws ClassNotFoundException {
		//Classloder.i++;
		//System.out.println(Classloder.i);
		ClassLoader cl=ClassLoader.getSystemClassLoader();
			cl.loadClass("test1.f1");//����+����***
			System.out.println("��������");
			Class.forName("test1.stack_heap");//��ʼ��
		java.net.URL[] urls=sun.misc.Launcher.
		getBootstrapClassPath().getURLs();
		for(int i=0;i<urls.length;i++)
		{
			System.out.println(urls[i].toExternalForm());
		}
		}
}

