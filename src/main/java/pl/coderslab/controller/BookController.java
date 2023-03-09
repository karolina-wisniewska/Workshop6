package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.bean.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return mockBookService.getAllBooks();
    }

    @GetMapping("/{index}")
    public Book getBookById(@PathVariable long index) {
        return mockBookService.getBookById(index);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        mockBookService.addBook(book);
    }

    @PutMapping("")
    public void editBook(@RequestBody Book book){
        mockBookService.editBook(book);
    }

    @DeleteMapping("/{index}")
    public void deleteBook(@PathVariable long index) {
        mockBookService.deleteBook(index);
    }
}
