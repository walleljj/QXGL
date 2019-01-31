package bean;

public class RolePermissions {
	private int role_id;
	private int permissions_id;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getPermissions_id() {
		return permissions_id;
	}
	public void setPermissions_id(int permissions_id) {
		this.permissions_id = permissions_id;
	}
	@Override
	public String toString() {
		return "RolePermissions [role_id=" + role_id + ", permissions_id=" + permissions_id + "]";
	}
	public RolePermissions(int role_id, int permissions_id) {
		super();
		this.role_id = role_id;
		this.permissions_id = permissions_id;
	}
	public RolePermissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
