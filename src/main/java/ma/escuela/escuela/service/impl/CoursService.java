package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Cours;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.repository.CoursRepository;
import ma.escuela.escuela.service.ICoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService implements ICoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours findCours(long id) throws NotFoundException {
        Optional<Cours> courseOptional = coursRepository.findById(id);
        if (!courseOptional.isPresent())
            throw new NotFoundException("COURS.NOT.FOUND", "Cours not found with id : " + id);
        return courseOptional.get();
    }

    @Override
    public Page<Cours> findAllCourses(PageRequest pageRequest) {
        return coursRepository.findAll(pageRequest);
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

    @Override
    public Page<Cours> searchCourses(PageRequest pageRequest, String keyword) {
        return coursRepository.findByNomContaining(keyword, pageRequest);
    }
}
