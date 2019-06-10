package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Cours;
import ma.escuela.escuela.domain.Panier;
import ma.escuela.escuela.domain.User;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.repository.PanierRepository;
import ma.escuela.escuela.service.ICoursService;
import ma.escuela.escuela.service.IPanierService;
import ma.escuela.escuela.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PanierService implements IPanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private ICoursService coursService;

    @Autowired
    private IUserService userService;

    @Override
    public Panier addCourseToPanier(Cours course) throws NotFoundException {
        User user = userService.getConnectedUser();
        if (user.getPanier() == null) {
            Panier panier = this.getPanierForConnectedUser();
            panier.getCourses().add(course);
            user.setPanier(panier);
        } else {
            user.getPanier().getCourses().add(course);
        }
        userService.updateUser(user);
        return user.getPanier();
    }

    @Override
    public Panier removeCourseFromPanier(Cours course) throws NotFoundException {
        User user = userService.getConnectedUser();
        Panier panier = user.getPanier();
        panier.setCourses(panier.getCourses().stream().filter(cours ->
                cours.getId() != course.getId()
        ).collect(Collectors.toList()));
        return panierRepository.save(panier);
    }

    @Override
    public Panier getPanierForConnectedUser() throws NotFoundException {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserByUsername(username);
        return user.getPanier() == null ? new Panier() : user.getPanier();
    }

    @Override
    public Panier removeCourseFromPanier(Long courseID) throws NotFoundException {
        Cours cours = this.coursService.findCours(courseID);
        return this.removeCourseFromPanier(cours);
    }
}
