package ihor0k.service;

import ihor0k.model.Book;

import java.io.File;
import java.util.List;

public interface BookService {
    void addBook(Book book, File file);

    void updateBook(Book book);

    void removeBook(int id);

    Book getBook(int id);

    List<Book> getAllBooks();
}
