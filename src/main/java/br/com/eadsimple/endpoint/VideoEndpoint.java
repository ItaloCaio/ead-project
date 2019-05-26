package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.error.ResourceNotFoundException;
import br.com.eadsimple.model.Video;
import br.com.eadsimple.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("video")
public class VideoEndpoint {

    private VideoRepository videoRepository;

    @Autowired
    public VideoEndpoint(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(videoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStreamById(@PathVariable("id") long id) {
        verifyIfVideoExists(id);
        Video video = videoRepository.findOne(id);
        if (video == null) {
            return new ResponseEntity<>(new CustomErrorType("Video not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(video, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<?> save(@RequestBody Video video) {

        return new ResponseEntity<>(videoRepository.save(video), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        verifyIfVideoExists(id);
        videoRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Video video) {
        verifyIfVideoExists(video.getId());
        videoRepository.save(video);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfVideoExists(Long id){
        if (videoRepository.findOne(id) == null)
            throw new ResourceNotFoundException("Class not found for ID: " + id);
    }



}
