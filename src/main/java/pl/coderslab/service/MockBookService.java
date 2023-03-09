package pl.coderslab.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import pl.coderslab.bean.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MockBookService {
    private List<Book> list;
    private static Long nextId = 4L;

    public static void main(String[] args) {
        MockBookService test = new MockBookService();
        test.addBook(new Book( "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
    }

    public MockBookService() {
        list = new ArrayList<>();

        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getAllBooks(){
        return this.list;
    }

    public Book getBookById(long index){
        return list.stream()
                .filter(n->n.getId()
                        .equals(index))
                .findAny()
                .orElse(null);
    }

    public void addBook(Book book){
        Book bookToAdd = new Book();
        bookToAdd.setId(nextId);
        bookToAdd.setIsbn(book.getIsbn());
        bookToAdd.setTitle(book.getTitle());
        bookToAdd.setAuthor(book.getAuthor());
        bookToAdd.setPublisher(book.getPublisher());
        bookToAdd.setType(book.getType());
        this.list.add(book);
        nextId++;
    }

    public void delete(long index){
        Book bookToDelete = list.stream()
                .filter(n->n.getId()
                        .equals(index)).
                findAny().
                orElse(null);
        list.remove(bookToDelete);
    }
}
