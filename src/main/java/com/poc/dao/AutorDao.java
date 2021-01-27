package com.poc.dao;

import java.util.Optional;
import java.util.UUID;

import com.poc.entity.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public interface AutorDao extends CrudRepository<Autor, Long> {
	Optional<Autor> findByUuid(UUID uuid);
}
