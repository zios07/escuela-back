package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Matiere;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface IMatiereService {

    Matiere addMatiere(Matiere matiere) throws ServiceException;

    Matiere findMatiere(long id) throws NotFoundException;

    List<Matiere> findAllMatieres();

    void deleteMatiere(long id) throws NotFoundException;

    List<Matiere> searchMatieres(Matiere matiereDto) throws NotFoundException;

    Matiere updateMatiere(Matiere matiere) throws NotFoundException;

}
