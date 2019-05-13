package br.com.eadsimple.repository;

import br.com.eadsimple.model.Tutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TutorRepository extends CrudRepository<Tutor, Long> {
    List<Tutor> findByNameIgnoreCaseContaining(String name);
}
