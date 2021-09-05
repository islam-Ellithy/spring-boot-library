package com.lamaa.library.repositories;

import com.lamaa.library.domain.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
    
}
