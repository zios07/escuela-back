package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Cours;
import ma.escuela.escuela.domain.Panier;
import ma.escuela.escuela.exception.NotFoundException;

public interface IPanierService {

    Panier addCourseToPanier(Cours course) throws NotFoundException;

    Panier removeCourseFromPanier(Cours course) throws NotFoundException;

    Panier getPanierForConnectedUser() throws NotFoundException;

    Panier removeCourseFromPanier(Long courseID) throws NotFoundException;
}
