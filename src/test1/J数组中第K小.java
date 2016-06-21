package test1;

public class J数组中第K小 {
	public static int Qsort(int[] a,int begin,int end, int k){
		 int i=begin,j=end;
		if(i==k){
			System.out.println(i+" "+a[i-1]);
			return a[i-1];
		}
		String flag="L";
		while(i<j&&i>0){ 
			if(flag.equals("L")){
				if(a[i]>a[j]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					flag="R";
					j--;
				}
				else
					i++;
			}
			if(flag.equals("R")){
					if(a[i]>a[j]){
						int temp=a[i];
						a[i]=a[j];
						a[j]=temp;
						flag="L";
						i++;
					}
					else
						j--;
			}
		}
		if(k>i)
		{
			return Qsort(a,i+1,end,k);
		}
		else
			return Qsort(a,begin,i-1,k);
	}
	public static void main(String[] args) {
		int[] a={1,5,2,6,8,0,6};
		Qsort(a,0,a.length-1,4);
	}

}
