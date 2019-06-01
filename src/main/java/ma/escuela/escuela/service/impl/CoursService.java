package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Cours;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.CoursRepository;
import ma.escuela.escuela.service.ICoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService implements ICoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public Cours addCours(Cours cours) throws ServiceException {
        return coursRepository.save(cours);
    }

    @Override
    public Cours findCours(long id) throws NotFoundException {
        Optional<Cours> coursOptional = coursRepository.findById(id);
        if (!coursOptional.isPresent())
            throw new NotFoundException("COURS.NOT.FOUND", "Cours not found with id : " + id);
        return coursOptional.get();
    }

    @Override
    public List<Cours> findAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public void deleteCours(long id) throws NotFoundException {
        coursRepository.deleteById(id);
    }

    @Override
    public List<Cours> searchCourses(Cours courseDto) throws NotFoundException {
        return null;
    }

    @Override
    public Cours updateCours(Cours cours) throws NotFoundException {
        return coursRepository.save(cours);
    }
}
