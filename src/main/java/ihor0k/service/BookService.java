package ihor0k.service;

import ihor0k.model.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    void addBook(Book book, MultipartFile file);

    void updateBook(Book book);

    void removeBook(int id);

    Book getBook(int id);

    List<Book> getAllBooks();
}
