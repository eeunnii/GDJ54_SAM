package prac01;

public class Main {

	public static void main(String[] args) {
	
		Bank me = new Bank("1234", 50000);
		Bank mom = new Bank("4567", 100000);
		
		mom.transfer(me, -5000000);
		
		me.accInfo();
		mom.accInfo();

	}

}
