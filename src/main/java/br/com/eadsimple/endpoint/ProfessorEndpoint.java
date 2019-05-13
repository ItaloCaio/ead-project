package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.model.Professor;
import br.com.eadsimple.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("professor")
public class ProfessorEndpoint {
    private final ProfessorRepository professorDAO;

    @Autowired
    public ProfessorEndpoint(ProfessorRepository professorDAO) {
        this.professorDAO = professorDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(professorDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProfessorById(@PathVariable("id") long id) {
        Professor professor = professorDAO.findOne(id);
        if (professor == null) {
            return new ResponseEntity<>(new CustomErrorType("Professor not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Professor professor) {
        return new ResponseEntity<>(professorDAO.save(professor), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        professorDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Professor professor) {
        professorDAO.save(professor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
