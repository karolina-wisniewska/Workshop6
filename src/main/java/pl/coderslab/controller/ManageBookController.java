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
  String processAddBookForm(@Valid Book book, BindingResult result) {
    if(result.hasErrors()){
      return "books/add";
    }
    bookService.addBook(book);
    return "redirect:all";
  }

  @GetMapping(path = "/edit")
  String showEditBookForm(Model model, @RequestParam Long id) {
    model.addAttribute("book", bookService.getBookById(id));
    return "books/edit";
  }

  @PostMapping(path = "/edit")
  String processEditBookForm(@Valid Book book, @RequestParam Long id, BindingResult result) {
    if(result.hasErrors()){
      return "books/edit";
    }
    bookService.updateBook(id, book);
    return "redirect:all";
  }

  @GetMapping(path = "/delete")
  String deleteBook(@RequestParam Long id) {
    bookService.deleteBook(id);
    return "redirect:all";
  }

  @GetMapping(path = "/details")
  String findById(@RequestParam Long id, Model model) {
    Book book = bookService.getBookById(id);
    model.addAttribute("book", book);
    return "books/details";
  }
}
