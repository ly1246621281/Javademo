package bishe;

public class strpipei {
	public static void main(String[] args) {
		String str1="ABCDABCEDA";
		String str2="ABCEDA";
		int count=0xFFFf;int j=0;
		for(int i=0;i<str1.length();i++)
			
			
			//for(int j=0;j<str2.length();j++)
			{
				
				if(str1.charAt(i)==str2.charAt(j)){
					j++;
					if(j==(str2.length()))
					   {
						count=i-str2.length()+1;
						break;
						}
					}
				else
					j=0;
			}		
		System.out.println(count);
	}
}
