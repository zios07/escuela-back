package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Eleve;
import ma.escuela.escuela.dto.ProfileDTO;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.EleveRepository;
import ma.escuela.escuela.service.IEleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleveService implements IEleveService {


    @Autowired
    private EleveRepository eleveRepository;

    @Override
    public Eleve addEleve(Eleve eleve) throws ServiceException {
        return eleveRepository.save(eleve);
    }

    @Override
    public Eleve findEleve(long id) throws NotFoundException {
        Optional<Eleve> eleveOptional = eleveRepository.findById(id);
        if (!eleveOptional.isPresent())
            throw new NotFoundException("ELEVE.NOT.FOUND", "Eleve not found with id : " + id);
        return eleveOptional.get();
    }

    @Override
    public List<Eleve> findAllEleves() {
        return eleveRepository.findAll();
    }

    @Override
    public void deleteEleve(long id) throws NotFoundException {
        eleveRepository.deleteById(id);
    }

    @Override
    public List<Eleve> searchEleves(Eleve eleveDto) throws NotFoundException {
        return null;
    }

    @Override
    public Eleve updateEleve(Eleve eleve) throws NotFoundException {
        return eleveRepository.save(eleve);
    }

    @Override
    public Eleve findEleveByUsername(String elevename) throws NotFoundException {
        return null;
    }

    @Override
    public Eleve getConnectedEleve() throws NotFoundException {
        return null;
    }

    @Override
    public Eleve updateEleveProfile(ProfileDTO eleve) {
        return null;
    }
}
