package ihor0k.controller;

import ihor0k.model.Book;
import ihor0k.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    private BookService bookService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "books";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        System.out.println(book.getFile().length);
        if (book.getId() == 0)
            bookService.addBook(book);
        else
            bookService.updateBook(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "addBook";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "book";
    }

    @Autowired()
    @Qualifier(value = "bookServiceImpl")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
