package ex07_constructor;

public class ComputerMain {

	public static void main(String[] args) {
		
		Computer myCom = new Computer();
		myCom.printComputerStatus();

		Computer yourCom = new Computer("gram", 150);
		yourCom.printComputerStatus();
		
	}

}
