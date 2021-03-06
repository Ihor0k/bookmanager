package ihor0k.controller;

import ihor0k.model.Book;
import ihor0k.model.User;
import ihor0k.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class BookController {
    private BookService bookService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String bookList(Model model) {
        model.addAttribute("bookList", bookService.getAllBooks());
        return "books";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "book/new", method = RequestMethod.GET)
    public String addBook() {
        return "addBook";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "book/new", method = RequestMethod.POST)
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("description") String description,
                          @RequestParam("file") CommonsMultipartFile multipartFile) {
        try {
            String filename = multipartFile.getOriginalFilename();
            File file = new File(filename);
            multipartFile.transferTo(file);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Book book = new Book(title, author, description, file.getName(), user);
            bookService.addBook(book, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "book";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/book/{id}/edit", method = RequestMethod.GET)
    public String editBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "editBook";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/book/{id}/edit", method = RequestMethod.POST)
    public String editBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/book/" + book.getId();
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/book/{id}/remove", method = RequestMethod.GET)
    public String removeBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
        return "redirect:/";
    }

    @Autowired
    @Qualifier("bookServiceImpl")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
