package br.com.eadsimple.repository;

import br.com.eadsimple.model.game.to.operate.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
