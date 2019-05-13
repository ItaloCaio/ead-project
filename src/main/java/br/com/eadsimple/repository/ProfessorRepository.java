package br.com.eadsimple.repository;

import br.com.eadsimple.model.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    List<Professor> findByNameIgnoreCaseContaining(String name);
}
