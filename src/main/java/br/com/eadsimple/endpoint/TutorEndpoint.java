package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.model.Tutor;
import br.com.eadsimple.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tutor")
public class TutorEndpoint {
    private final TutorRepository tutorDAO;

    @Autowired
    public TutorEndpoint(TutorRepository tutorDAO) {
        this.tutorDAO = tutorDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(tutorDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTutorById(@PathVariable("id") long id) {
        Tutor tutor = tutorDAO.findOne(id);
        if (tutor == null) {
            return new ResponseEntity<>(new CustomErrorType("Tutor not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Tutor tutor) {
        return new ResponseEntity<>(tutorDAO.save(tutor), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        tutorDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Tutor tutor) {
        tutorDAO.save(tutor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
