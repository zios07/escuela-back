package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Cours;
import ma.escuela.escuela.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICoursService {

    Cours addCours(Cours cours);

    Cours findCours(long id) throws NotFoundException;

    Page<Cours> findAllCourses(PageRequest of);

    void deleteCours(long id) throws NotFoundException;

    List<Cours> searchCourses(Cours courseDto) throws NotFoundException;

    Cours updateCours(Cours cours) throws NotFoundException;

    Page<Cours> searchCourses(PageRequest of, String keyword);
}
