package prac04_employee;

public class Regular extends Employee {

	private int salary;

	public Regular(int empNo, String name, int salary) {
		super(empNo, name);
		this.salary = salary;
	}

	@Override
	public String toString() {
		return super.toString() + ", salary=" + salary + "]";
	}
	@Override
	public int getPay() {
		return salary;  // 정규직은 salary가 월급
	}
	
}
