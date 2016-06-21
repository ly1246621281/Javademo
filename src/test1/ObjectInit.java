package test1;

class SuperClass {
	private static String STR = "Super Class Static Variable";
	static {
		System.out.println("Super Class Static Block:" + STR);
	}

	public SuperClass() {
		System.out.println("Super Class Constructor Method");
	}

	{
		System.out.println("Super Class Block");
	}

}

public class ObjectInit extends SuperClass {
	private static String STR = "Class Static Variable";
	static {
		System.out.println("Class Static Block:" + STR);
	}

	public ObjectInit() {
		System.out.println("Constructor Method");
	}

	{
		System.out.println("Class Block");
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ObjectInit a = new ObjectInit();
	}
}