package aaaa;

public class UserDll {

	static{
		System.loadLibrary("CreateDLL");
	}
	public static native int Add1(int a,int b);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UserDll ud=new UserDll();
		int num = UserDll.Add1(10, 10);
		System.out.println("Add is "+num);
	}

}
