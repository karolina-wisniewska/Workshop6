package pl.coderslab.service;

import pl.coderslab.entity.Book;

import java.util.List;

public interface BookService {

  List<Book> getAllBooks();
  Book getBookById(long index);
  void addBook(Book book);
  void updateBook(long bookId, Book book);
  void deleteBook(long index);
}
