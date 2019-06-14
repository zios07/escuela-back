package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Eleve;
import ma.escuela.escuela.dto.ProfileDTO;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface IEleveService {

    Eleve addEleve(Eleve eleve) throws ServiceException, NotFoundException;

    Eleve findEleve(long id) throws NotFoundException;

    List<Eleve> findAllEleves();

    void deleteEleve(long id) throws NotFoundException;

    List<Eleve> searchEleves(Eleve eleveDto) throws NotFoundException;

    Eleve updateEleve(Eleve eleve) throws NotFoundException;

    Eleve findEleveByUsername(String elevename) throws NotFoundException;

    Eleve getConnectedEleve() throws NotFoundException;

    Eleve updateEleveProfile(ProfileDTO eleve);

    List<Eleve> findElevesByParent(Long parentID);
}
