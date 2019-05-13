package br.com.eadsimple.repository;

import br.com.eadsimple.model.game.to.operate.Level;
import org.springframework.data.repository.CrudRepository;

public interface LevelRepository extends CrudRepository<Level, Long> {
}
