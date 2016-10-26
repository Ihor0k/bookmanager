package ihor0k.service;

import ihor0k.DAO.BookDAO;
import ihor0k.DAO.BookDAOImpl;
import ihor0k.model.Book;
import ihor0k.service.storage.StorageException;
import ihor0k.service.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;
    private StorageService storageService;

    private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);


    @Override
    @Transactional
    public void addBook(Book book, File file) {
        bookDAO.addBook(book);
        try {
            storageService.store(file);
        } catch (StorageException e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        String filename = bookDAO.getBook(id).getFilename();
        try {
            storageService.delete(filename);
        } catch (StorageException e) {
            logger.warn(e.getMessage());
        }
        bookDAO.removeBook(id);
    }

    @Override
    @Transactional
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Autowired
    @Qualifier(value = "fileSystemStorageService")
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
