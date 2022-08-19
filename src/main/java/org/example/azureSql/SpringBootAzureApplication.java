package org.example.azureSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class SpringBootAzureApplication {

    @Autowired
    private BookRepository repository;

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return repository.findAll();
    }


    @GetMapping("/book/{id}")
    public Optional<Book> getBook(@PathVariable int id) {
        //return getBookById(id);
        return repository.findById(id);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id) {
        repository.deleteById(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAzureApplication.class, args);

    }
}
