package ma.escuela.escuela.repository;

import ma.escuela.escuela.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByAccountId(Long accountID);
	User findByAccountUsername(String username);

	
}	
