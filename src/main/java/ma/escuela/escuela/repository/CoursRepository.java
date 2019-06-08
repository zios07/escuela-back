package ma.escuela.escuela.repository;

import ma.escuela.escuela.domain.Cours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    Page<Cours> findByNomContaining(String nom, Pageable pageable);
}
