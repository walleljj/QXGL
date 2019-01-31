package bean;

public class PermissionResources {
	private int permission_id;
	private int resources_id;
	public int getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}
	public int getResources_id() {
		return resources_id;
	}
	public void setResources_id(int resources_id) {
		this.resources_id = resources_id;
	}
	@Override
	public String toString() {
		return "PermissionResources [permission_id=" + permission_id + ", resources_id=" + resources_id + "]";
	}
	public PermissionResources(int permission_id, int resources_id) {
		super();
		this.permission_id = permission_id;
		this.resources_id = resources_id;
	}
	public PermissionResources() {
		super();
		// TODO Auto-generated constructor stub
		//测试
	}
	

}
