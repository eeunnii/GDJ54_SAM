package prac09;

public class Main {

	public static void main(String[] args) {

		BankAccount me = new BankAccount("1234", 50000L);
		BankAccount mom = new BankAccount("5678", 100000L);
		
		mom.transfer(me, 300000);
		
		me.inquiry();
		mom.inquiry();
		
	}

}
