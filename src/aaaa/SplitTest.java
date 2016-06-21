package aaaa;

public class SplitTest {
	public static void main(String[] args) {
		String str1 = "a-b";		
		String str2 = "a-b-";
		String str3 = "-a-b";
		String str4 = "-a-b-";
		String str5 = "a";
		String str6 = "-";
		String str7 = "--";
		String str8 = "";
		
		split(str1);
		split(str2);
		split(str3);
		split(str4);
		split(str5);
		split(str6);
		split(str7);
		split(str8);
	}
	public static void split(String demo){
		String[] array = demo.split("-");
		int len = array.length;
		System.out.print("\"" + demo + "\" 分割后的长度为：" + len);
		if(len >= 0)
		{
			System.out.print(",分割后的结果为：");
			for(int i=0; i<len; i++)
			{
				System.out.print(" \""+array[i]+"\"");
			}			
		}
		System.out.println();
	}
}