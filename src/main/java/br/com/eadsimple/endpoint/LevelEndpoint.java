package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.model.game.to.operate.Level;
import br.com.eadsimple.model.game.to.operate.Question;
import br.com.eadsimple.repository.LevelRepository;
import br.com.eadsimple.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("level")
public class LevelEndpoint {
    private final LevelRepository levelRepository;

    @Autowired
    public LevelEndpoint(LevelRepository levelRepository){
        this.levelRepository = levelRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(levelRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {

        Level level = levelRepository.findOne(id);
        if (level == null) {
            return new ResponseEntity<>(new CustomErrorType("Level not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(level, HttpStatus.OK);
    }
}
