package bean;

public class User {
	private int id;
	private String password;
	private String name;
	private String realname;
	private String tel;
	private String emal;
	public User(int id,String password, String name, String realname, String tel, String emal) {
		super();
		this.id=id;
		this.password = password;
		this.name = name;
		this.realname = realname;
		this.tel = tel;
		this.emal = emal;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmal() {
		return emal;
	}
	public void setEmal(String emal) {
		this.emal = emal;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [password=" + password + ", name=" + name + ", realname=" + realname + ", tel=" + tel + ", emal="
				+ emal + "]";
	}
	
	

}
