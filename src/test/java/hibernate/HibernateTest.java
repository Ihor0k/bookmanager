package hibernate;

import ihor0k.DAO.BookDAO;
import ihor0k.DAO.UserDAO;
import ihor0k.model.Book;
import ihor0k.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml", "classpath:hibernate.cfg.xml"})
public class HibernateTest {
    private BookDAO bookDAO;
    private UserDAO userDAO;

    @Test
    @Transactional
    @Rollback
    public void createTest() {
        User user = userDAO.getUser("admin");
        Book book = new Book("title", "author", "description", "filename", user);
        bookDAO.addBook(book);
        List<Book> booksList = bookDAO.getAllBooks();
        assertEquals(book.getTitle(), booksList.get(booksList.indexOf(book)).getTitle());
    }

    @Test
    @Transactional
    @Rollback
    public void updateTest() {
        User user = userDAO.getUser("admin");
        Book book = new Book("title", "author", "description", "filename", user);
        bookDAO.addBook(book);
        Book newBook = new Book();
        for (Book b : bookDAO.getAllBooks()) {
            if (b.getTitle().equals("title"))
                newBook = b;
        }
        newBook.setTitle("newTitle");
        bookDAO.updateBook(newBook );
        assertEquals("newTitle", bookDAO.getBook(newBook.getId()).getTitle());
    }

    @Autowired
    @Qualifier("userDAOImpl")
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    @Qualifier("bookDAOImpl")
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
}
