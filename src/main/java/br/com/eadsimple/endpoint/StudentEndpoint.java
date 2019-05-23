package br.com.eadsimple.endpoint;

import br.com.eadsimple.error.CustomErrorType;
import br.com.eadsimple.model.Student;
import br.com.eadsimple.model.User;
import br.com.eadsimple.repository.StudentRepository;
import br.com.eadsimple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentEndpoint {
    private final StudentRepository studentDAO;
    private final UserRepository userRepository;

    @Autowired
    public StudentEndpoint(StudentRepository studentDAO, UserRepository userRepository) {
        this.studentDAO = studentDAO;
        this.userRepository = userRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(studentDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {

        Student student = studentDAO.findOne(id);
        if (student == null) {
            return new ResponseEntity<>(new CustomErrorType("Student not found "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(path = "/tt")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal UserDetails userDetails) {

        User user = userRepository.findByUsername(userDetails.getUsername());
        System.out.println("Usuário retornado: " + userDetails);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {

        student.setPassword(new BCryptPasswordEncoder().encode(student.getPassword()));

        return new ResponseEntity<>(studentDAO.save(student), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        studentDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        studentDAO.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
