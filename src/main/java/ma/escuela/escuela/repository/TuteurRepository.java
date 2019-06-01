package ma.escuela.escuela.repository;

import ma.escuela.escuela.domain.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuteurRepository extends JpaRepository<Tuteur, Long> {
}
