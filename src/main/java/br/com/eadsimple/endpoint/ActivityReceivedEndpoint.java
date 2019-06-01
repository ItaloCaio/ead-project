package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.error.ResourceNotFoundException;
import br.com.eadsimple.model.ActivityAssigned;
import br.com.eadsimple.model.ActivityReceived;
import br.com.eadsimple.repository.ActivityReceivedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("activityReceived")
public class ActivityReceivedEndpoint {

    @Autowired
    private ActivityReceivedRepository activityReceivedRepository;

    public ActivityReceivedEndpoint(ActivityReceivedRepository activityReceivedRepository){
        this.activityReceivedRepository = activityReceivedRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(activityReceivedRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getActivityById(@PathVariable("id") long id) {
        verifyIfActivityExists(id);
        ActivityReceived activityReceived = activityReceivedRepository.findOne(id);
        if (activityReceived == null) {
            return new ResponseEntity<>(new CustomErrorType("Activity not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(activityReceived, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<?> save(@RequestBody ActivityReceived activityReceived) {

        return new ResponseEntity<>(activityReceivedRepository.save(activityReceived), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        verifyIfActivityExists(id);
        activityReceivedRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ActivityReceived activityReceived) {
        verifyIfActivityExists(activityReceived.getId());
        activityReceivedRepository.save(activityReceived);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfActivityExists(Long id){
        if (activityReceivedRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Activity not found for ID: " + id);
    }
}
