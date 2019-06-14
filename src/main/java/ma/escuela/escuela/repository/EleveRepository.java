package ma.escuela.escuela.repository;

import ma.escuela.escuela.domain.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long> {
    Eleve findByAccountUsername(String username);

    List<Eleve> findByParentId(Long parentID);

    List<Eleve> findByParentAccountUsername(String parentUsername);
}
