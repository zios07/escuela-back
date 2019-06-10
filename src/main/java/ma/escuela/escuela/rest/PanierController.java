package ma.escuela.escuela.rest;

import ma.escuela.escuela.domain.Cours;
import ma.escuela.escuela.domain.Panier;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.service.IPanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("api/paniers")
public class PanierController {

    @Autowired
    private IPanierService panierService;

    @GetMapping
    public Panier getPanierForConnectedUser() throws NotFoundException {
        return this.panierService.getPanierForConnectedUser();
    }

    @PostMapping
    public Panier addCourseToPanier(@RequestBody Cours course) throws NotFoundException {
        return this.panierService.addCourseToPanier(course);
    }

    @DeleteMapping(value = "/delete/course/{id}")
    public void deleteCourseFromPanier(@PathVariable Long id) throws NotFoundException {
        this.panierService.removeCourseFromPanier(id);
    }
}
