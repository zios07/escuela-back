package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Role;
import ma.escuela.escuela.domain.User;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.RoleRepository;
import ma.escuela.escuela.repository.UserRepository;
import ma.escuela.escuela.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static ma.escuela.escuela.util.UtilContants.ROLE_CODE_ADMIN;
import static ma.escuela.escuela.util.UtilContants.ROLE_CODE_USER;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private RoleRepository repo;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Role findRoleByUsername(String username) throws ServiceException {
		User user = userRepository.findByAccountUsername(username);
		if(user == null)
			throw new ServiceException("INVALID.USERNAME", "Invalid username");
		
		return user.getRole();
	}

	@Override
	public Role findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Role> findAll() {
		return repo.findAll();
	}

	@Override
	public Role getRoleUser() {
		return repo.findByRoleCode(ROLE_CODE_USER);
	}

	@Override
	public Role getRoleAdmin() {
		return repo.findByRoleCode(ROLE_CODE_ADMIN);
	}

	@Override
	public Role findByCode(String roleCode) {
		return repo.findByRoleCode(roleCode);
	}

}
