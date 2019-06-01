package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Jeux;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface IJeuxService {

    Jeux addJeux(Jeux jeux) throws ServiceException;

    Jeux findJeux(long id) throws NotFoundException;

    List<Jeux> findAllJeux();

    void deleteJeux(long id) throws NotFoundException;

    List<Jeux> searchJeux(Jeux jeuxDto) throws NotFoundException;

    Jeux updateJeux(Jeux jeux) throws NotFoundException;

}
