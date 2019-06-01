package ma.escuela.escuela.repository;

import ma.escuela.escuela.domain.Jeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeuxRepository extends JpaRepository<Jeux, Long> {
}
