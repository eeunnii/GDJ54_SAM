package prac09;

public class BankAccount {

	private String accNo;  // 계좌번호
	private long balance;  // 잔고
	
	public BankAccount(String accNo, long balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}
	
	// 입금
	public void deposit(long money) {
		if(money < 0)
			return;
		balance += money;
	}
	
	// 출금
	public long withdraw(long money) {
		if(money < 0 || money > balance)
			return 0;
		balance -= money;
		return money;
	}
	
	// 이체
	public void transfer(BankAccount other, long money) {
		// 출금 후 입금 순서로 동작해야 함.
		// 실제 출금액을 입금액으로 전달함.
		other.deposit(withdraw(money));
	}
	
	// 조회
	public void inquiry() {
		System.out.println("계좌번호: " + accNo + ", 잔고: " + balance + "원");
	}
	
}
