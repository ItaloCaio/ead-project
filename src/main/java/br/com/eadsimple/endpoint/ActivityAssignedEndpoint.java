package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.error.ResourceNotFoundException;
import br.com.eadsimple.model.ActivityAssigned;
import br.com.eadsimple.model.Class;
import br.com.eadsimple.repository.ActivityAssignedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("activityAssigned")
public class ActivityAssignedEndpoint {

    @Autowired
    ActivityAssignedRepository activityAssignedRepository;

    public ActivityAssignedEndpoint(ActivityAssignedRepository activityAssignedRepository){
        this.activityAssignedRepository = activityAssignedRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(activityAssignedRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getActivityById(@PathVariable("id") long id) {
        verifyIfActivityExists(id);
        ActivityAssigned activityAssigned = activityAssignedRepository.findOne(id);
        if (activityAssigned == null) {
            return new ResponseEntity<>(new CustomErrorType("Activity not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(activityAssigned, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<?> save(@RequestBody ActivityAssigned activityAssigned) {

        return new ResponseEntity<>(activityAssignedRepository.save(activityAssigned), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        verifyIfActivityExists(id);
        activityAssignedRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ActivityAssigned activityAssigned) {
        verifyIfActivityExists(activityAssigned.getId());
        activityAssignedRepository.save(activityAssigned);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfActivityExists(Long id){
        if (activityAssignedRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Activity not found for ID: " + id);
    }
}
