package hibernate;

import ihor0k.DAO.BookDAO;
import ihor0k.model.Book;
import ihor0k.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml", "classpath:hibernate.cfg.xml"})
public class HibernateTest {
    private BookDAO bookDAOImpl;

    @Test
    @Transactional
    @Rollback
    public void createTest() {
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setDescription("description");
        book.setFilename("path");
        book.setUser(new User());
        bookDAOImpl.addBook(book);
        List<Book> booksList = bookDAOImpl.getAllBooks();
        Assert.assertEquals(book.getTitle(), booksList.get(booksList.indexOf(book)).getTitle());
    }



    @Autowired
    @Qualifier(value = "bookDAOImpl")
    public void setBookDAOImpl(BookDAO bookDAOImpl) {
        this.bookDAOImpl = bookDAOImpl;
    }
}
