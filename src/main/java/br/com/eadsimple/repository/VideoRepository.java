package br.com.eadsimple.repository;

import br.com.eadsimple.model.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {
}
