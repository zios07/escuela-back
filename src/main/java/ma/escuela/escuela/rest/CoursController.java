package ma.escuela.escuela.rest;

import ma.escuela.escuela.domain.Cours;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.service.ICoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CoursController {

    @Autowired
    private ICoursService service;

    @GetMapping(value = "{id}")
    public ResponseEntity<Cours> findCourse(@PathVariable long id) throws NotFoundException {
        Cours course = service.findCours(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cours>> findAllCourses() {
        List<Cours> courses = service.findAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cours> addCourse(@RequestBody Cours cours) throws ServiceException {
        Cours savedCourse = service.addCours(cours);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id) throws NotFoundException {
        service.deleteCours(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<Cours>> searchCourses(@RequestBody Cours courseDto) throws NotFoundException {
        List<Cours> courses = service.searchCourses(courseDto);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


}
