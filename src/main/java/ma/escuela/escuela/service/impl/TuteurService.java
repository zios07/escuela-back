package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Tuteur;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.TuteurRepository;
import ma.escuela.escuela.service.ITuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TuteurService implements ITuteurService {

    @Autowired
    private TuteurRepository tuteurRepository;

    @Override
    public Tuteur addTuteur(Tuteur tuteur) throws ServiceException {
        return tuteurRepository.save(tuteur);
    }

    @Override
    public Tuteur findTuteur(long id) throws NotFoundException {
        Optional<Tuteur> tuteurOptional = tuteurRepository.findById(id);
        if (!tuteurOptional.isPresent())
            throw new NotFoundException("TUTEUR.NOT.FOUND", "Tuteur not found with id : " + id);
        return tuteurOptional.get();
    }

    @Override
    public List<Tuteur> findAllTuteurs() {
        return tuteurRepository.findAll();
    }

    @Override
    public void deleteTuteur(long id) throws NotFoundException {
        tuteurRepository.deleteById(id);
    }

    @Override
    public Tuteur updateTuteur(Tuteur tuteur) throws NotFoundException {
        return tuteurRepository.save(tuteur);
    }
}
