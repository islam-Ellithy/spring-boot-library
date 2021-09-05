package com.lamaa.library.repositories;
import com.lamaa.library.domain.Book;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book,Long> {
    
}
