package ma.escuela.escuela.repository;

import ma.escuela.escuela.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleCode(String roleCode);
}
