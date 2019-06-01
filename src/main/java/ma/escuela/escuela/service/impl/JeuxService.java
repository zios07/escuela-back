package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Jeux;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.JeuxRepository;
import ma.escuela.escuela.service.IJeuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JeuxService implements IJeuxService {

    @Autowired
    private JeuxRepository jeuxRepository;

    @Override
    public Jeux addJeux(Jeux jeux) throws ServiceException {
        return jeuxRepository.save(jeux);
    }

    @Override
    public Jeux findJeux(long id) throws NotFoundException {
        Optional<Jeux> jeuxOptional = jeuxRepository.findById(id);
        if (!jeuxOptional.isPresent())
            throw new NotFoundException("JEUX.NOT.FOUND", "Jeux not found with id : " + id);
        return jeuxOptional.get();
    }

    @Override
    public List<Jeux> findAllJeux() {
        return jeuxRepository.findAll();
    }

    @Override
    public void deleteJeux(long id) throws NotFoundException {
        jeuxRepository.deleteById(id);
    }

    @Override
    public List<Jeux> searchJeux(Jeux jeuxDto) throws NotFoundException {
        return null;
    }

    @Override
    public Jeux updateJeux(Jeux jeux) throws NotFoundException {
        return jeuxRepository.save(jeux);
    }
}
