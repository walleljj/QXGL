package bean;

public class Permissions {
	private int id;
	private String name;
	private String desceription;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesceription() {
		return desceription;
	}
	public void setDesceription(String desceription) {
		this.desceription = desceription;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Permissions [name=" + name + ", desceription=" + desceription + "]";
	}
	
	public Permissions(int id, String name, String desceription) {
		super();
		this.id = id;
		this.name = name;
		this.desceription = desceription;
	}
	public Permissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
