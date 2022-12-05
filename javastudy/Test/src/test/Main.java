package test;

public class Main {

	public static void main(String[] args) {
		
		SecurityUtil util = new SecurityUtil();
		
		System.out.println(util.sha256("1111"));
		System.out.println(util.sha256("2222"));
		System.out.println(util.sha256("3333"));
		System.out.println(util.sha256("4444"));
		System.out.println(util.sha256("5555"));

	}

}
