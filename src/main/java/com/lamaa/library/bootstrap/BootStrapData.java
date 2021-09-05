package com.lamaa.library.bootstrap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.lamaa.library.domain.Author;
import com.lamaa.library.domain.Book;
import com.lamaa.library.repositories.AuthorRepository;
import com.lamaa.library.repositories.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    BootStrapData(BookRepository bookRepository,AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        try{

        Author islam = new Author("islam","emam");
        Book ddd = new Book("Design drive drinking","13455");
        islam.getBooks().add(ddd);
        ddd.getAuthors().add(islam);

        bookRepository.save(ddd);



        Author mohmed = new Author("moh","salah");
        Book football = new Book("football liverpool","3423423");
        mohmed.getBooks().add(football);

        authorRepository.save(mohmed);
        
        System.out.println("Num of authors = " + authorRepository.count());
        System.out.println("Num of books = " + bookRepository.count());

        List<Author> authors = StreamSupport.stream(authorRepository.findAll().spliterator(),false).collect(Collectors.toList());

        List<Book> books = StreamSupport.stream(bookRepository.findAll().spliterator(),false).collect(Collectors.toList());

        books.forEach(System.out::println);
        List<Author> firstBookAuthor = StreamSupport.stream(books.get(0).getAuthors().spliterator(),false).collect(Collectors.toList()); 
        

        firstBookAuthor.forEach(System.out::println);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
