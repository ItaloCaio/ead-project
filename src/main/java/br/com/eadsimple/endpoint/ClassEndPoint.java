package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.error.ResourceNotFoundException;
import br.com.eadsimple.model.Class;
import br.com.eadsimple.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("class")
public class ClassEndPoint {

    private final ClassRepository classRepository;

    @Autowired
    public ClassEndPoint(ClassRepository classRepository){
        this.classRepository = classRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(classRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getClassById(@PathVariable("id") long id) {
        verifyIfStudentExists(id);
        Class aClass = classRepository.findOne(id);
        if (aClass == null) {
            return new ResponseEntity<>(new CustomErrorType("Class not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(aClass, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<?> save(@RequestBody Class aClass) {

        return new ResponseEntity<>(classRepository.save(aClass), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        verifyIfStudentExists(id);
        classRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Class aClass) {
        verifyIfStudentExists(aClass.getId());
        classRepository.save(aClass);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfStudentExists(Long id){
        if (classRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Class not found for ID: " + id);
    }

}
