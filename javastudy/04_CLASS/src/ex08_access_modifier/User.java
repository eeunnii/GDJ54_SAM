package ex08_access_modifier;

public class User {

	// 필드는 private이다.
	private String id;
	private String password;
	private String email;
	private int point;
	private boolean isVip;
	
	// 메소드는 public이다.
	public String getId() {
		return id;
	}
	public void setId(String pId) {
		id = pId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pPassword) {
		password = pPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String pEmail) {
		email = pEmail;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int pPoint) {
		point = pPoint;
		setVip(point >= 10000);  // private 메소드 호출
	}
	public boolean getVip() {
		return isVip;
	}
	
	// private 메소드이므로 외부에서는 호출할 수 없음
	private void setVip(boolean pVip) {
		isVip = pVip;
	}
	
}