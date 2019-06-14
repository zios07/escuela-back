package ma.escuela.escuela.rest;

import ma.escuela.escuela.domain.Eleve;
import ma.escuela.escuela.dto.ProfileDTO;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.service.IEleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/eleves")
public class EleveController {

	@Autowired
	private IEleveService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<Eleve> findEleve(@PathVariable long id) throws NotFoundException {
		Eleve eleve = service.findEleve(id);
		return new ResponseEntity<>(eleve, HttpStatus.OK);
	}

	@GetMapping(value = "/username/{username}")
	public ResponseEntity<Eleve> findEleveByUsername(@PathVariable String username) throws NotFoundException {
		Eleve eleve = service.findEleveByUsername(username);
		return new ResponseEntity<>(eleve, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Eleve>> findAllEleves() {
		List<Eleve> eleves = service.findAllEleves();
		return new ResponseEntity<>(eleves, HttpStatus.OK);
	}

	@GetMapping(value = "/parent/{parentID}")
	public ResponseEntity<List<Eleve>> findEleveByParent(@PathVariable(required = false) Long parentID) {
		List<Eleve> eleves = service.findElevesByParent(parentID);
		return new ResponseEntity<>(eleves, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Eleve> addEleve(@RequestBody Eleve eleve) throws ServiceException, NotFoundException {
		Eleve savedEleve = service.addEleve(eleve);
		return new ResponseEntity<>(savedEleve, HttpStatus.CREATED);
	}

    @PutMapping
    public ResponseEntity<Eleve> updateEleve(@RequestBody Eleve eleve) throws NotFoundException {
        Eleve updatedEleve = service.updateEleve(eleve);
        return new ResponseEntity<Eleve>(updatedEleve, HttpStatus.CREATED);
    }

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deleteEleve(@PathVariable long id) throws NotFoundException {
		service.deleteEleve(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
