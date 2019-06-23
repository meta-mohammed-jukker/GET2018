package stringPack;

public class StringMain {
	public static void main(String[] args) {
		
		String obj = new StringOperations().toReverse("heyme boy");
		System.out.println(obj);
		
		String obj1 = new StringOperations().largest("This is your captain");
		System.out.println(obj1);
		
		
	}
}
