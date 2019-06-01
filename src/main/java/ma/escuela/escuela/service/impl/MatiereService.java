package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Matiere;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.MatiereRepository;
import ma.escuela.escuela.service.IMatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService implements IMatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    @Override
    public Matiere addMatiere(Matiere matiere) throws ServiceException {
        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere findMatiere(long id) throws NotFoundException {
        Optional<Matiere> matiereOptional = matiereRepository.findById(id);
        if (!matiereOptional.isPresent())
            throw new NotFoundException("MATIERE.NOT.FOUND", "Matiere not found with id : " + id);
        return matiereOptional.get();
    }

    @Override
    public List<Matiere> findAllMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public void deleteMatiere(long id) throws NotFoundException {
        matiereRepository.deleteById(id);
    }

    @Override
    public List<Matiere> searchMatieres(Matiere matiereDto) throws NotFoundException {
        return null;
    }

    @Override
    public Matiere updateMatiere(Matiere matiere) throws NotFoundException {
        return matiereRepository.save(matiere);
    }
}
