package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.bean.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
//@RequestMapping("/books")
public class BookController {

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(MockBookService mockBookService) {
        return mockBookService.getAllBooks();
    }


    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        // operacje na obiekcie book

    }
}
