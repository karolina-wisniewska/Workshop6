package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

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
    return "book/all";
  }

}
