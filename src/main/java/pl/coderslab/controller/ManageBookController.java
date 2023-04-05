package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class ManageBookController {

  private final BookService bookService;

  @GetMapping("/all")
  public String showPosts(Model model) {
    List<Book> books = bookService.getAllBooks();
    model.addAttribute("books", books);
    return "books/all";
  }

  @GetMapping(path = "/add")
  String showAddBookForm(Model model) {
    model.addAttribute("book", new Book());
    return "books/add";
  }

  @PostMapping(path = "/add")
  String processAddBookForm(Book book) {
    bookService.addBook(book);
    return "redirect:all";
  }

  @GetMapping(path = "/edit")
  String showEditBookForm(Model model, @RequestParam Long id) {
    model.addAttribute("book", bookService.getBookById(id));
    return "books/edit";
  }

  @PostMapping(path = "/edit")
  String processEditBookForm(Book book, @RequestParam Long id) {
    bookService.updateBook(id, book);
    return "redirect:all";
  }

}