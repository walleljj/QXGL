package service.impl;

import java.util.List;

import bean.Role;
import dao.IRoleDao;
import dao.impl.RoleDaoImpl;
import service.IRoleService;

public class RoleServiceImpl implements IRoleService {
	IRoleDao roleDao = new RoleDaoImpl();
	@Override
	public List<Role> listAllRole() {
		List<Role> list = null;
		list = roleDao.queryAll();
		return list;
		
	}
	@Override
	public void deletRoleById(String id) {
		// TODO Auto-generated method stub
		roleDao.deletRoleById(id);
		
	}

}
