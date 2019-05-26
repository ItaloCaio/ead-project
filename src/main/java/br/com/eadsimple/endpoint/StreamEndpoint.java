package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.error.ResourceNotFoundException;
import br.com.eadsimple.model.Class;
import br.com.eadsimple.model.Stream;
import br.com.eadsimple.repository.ClassRepository;
import br.com.eadsimple.repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stream")
public class StreamEndpoint {

    private StreamRepository streamRepository;

    @Autowired
    public StreamEndpoint(StreamRepository streamRepository){
        this.streamRepository = streamRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(streamRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStreamById(@PathVariable("id") long id) {
        verifyIfStreamExists(id);
        Stream stream = streamRepository.findOne(id);
        if (stream == null) {
            return new ResponseEntity<>(new CustomErrorType("Class not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stream, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<?> save(@RequestBody Stream stream) {

        return new ResponseEntity<>(streamRepository.save(stream), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        verifyIfStreamExists(id);
        streamRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Stream stream) {
        verifyIfStreamExists(stream.getId());
        streamRepository.save(stream);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfStreamExists(Long id){
        if (streamRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Class not found for ID: " + id);
    }





}
