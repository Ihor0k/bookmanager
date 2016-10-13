package ihor0k.controller;

import ihor0k.model.Book;
import ihor0k.service.BookService;
import ihor0k.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BookController {
    private BookService bookService;
    private StorageService storageService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "books";
    }

    @RequestMapping(value = "/file/{file_name:.+\\.pdf}", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
        response.setHeader("Content-Disposition", "inline; filename=" + fileName);
        return new FileSystemResource(storageService.load(fileName));
    }

    @RequestMapping(value = "book/new", method = RequestMethod.GET)
    public String addBook() {
        return "addBook";
    }

    @RequestMapping(value = "book/new", method = RequestMethod.POST)
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("description") String description,
                          @RequestParam("file") CommonsMultipartFile file) {
        System.out.println(file.getBytes().length);
        Book book = new Book(title, author, description, file.getOriginalFilename());
        storageService.store(file);
        bookService.addBook(book);
        return "redirect:/";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "book";
    }

    @RequestMapping(value = "/book/{id}/edit", method = RequestMethod.GET)
    public String editBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "addBook";
    }

    @RequestMapping(value = "/book/{id}/remove", method = RequestMethod.GET)
    public String removeBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
        return "redirect:/";
    }

    @Autowired
    @Qualifier(value = "bookServiceImpl")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    @Qualifier(value = "fileSystemStorageService")
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
