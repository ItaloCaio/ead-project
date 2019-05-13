package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.model.Student;
import br.com.eadsimple.model.game.to.operate.Question;
import br.com.eadsimple.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
public class QuestionEndpoint {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionEndpoint(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {

        Question question = questionRepository.findOne(id);
        if (question == null) {
            return new ResponseEntity<>(new CustomErrorType("Question not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}
