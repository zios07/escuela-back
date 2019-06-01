package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Tuteur;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface ITuteurService {

    Tuteur addTuteur(Tuteur tuteur) throws ServiceException;

    Tuteur findTuteur(long id) throws NotFoundException;

    List<Tuteur> findAllTuteurs();

    void deleteTuteur(long id) throws NotFoundException;

    Tuteur updateTuteur(Tuteur tuteur) throws NotFoundException;

}
