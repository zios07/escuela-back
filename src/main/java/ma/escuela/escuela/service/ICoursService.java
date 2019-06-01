package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Cours;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface ICoursService {

    Cours addCours(Cours cours) throws ServiceException;

    Cours findCours(long id) throws NotFoundException;

    List<Cours> findAllCourses();

    void deleteCours(long id) throws NotFoundException;

    List<Cours> searchCourses(Cours courseDto) throws NotFoundException;

    Cours updateCours(Cours cours) throws NotFoundException;

}
