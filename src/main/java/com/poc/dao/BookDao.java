package com.poc.dao;

import java.util.Optional;
import java.util.UUID;

import com.poc.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public interface BookDao extends CrudRepository<Book, Long> {
	Optional<Book> findByUuid(UUID uuid);
}