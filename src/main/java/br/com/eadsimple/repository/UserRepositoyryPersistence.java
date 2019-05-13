package br.com.eadsimple.repository;


import br.com.eadsimple.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoyryPersistence extends CrudRepository<User, Long> {
    List<User> findByNameIgnoreCaseContaining(String name);


}
