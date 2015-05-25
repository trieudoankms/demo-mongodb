package controller;

import domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;

import java.util.List;

/**
 * Created by trieudoan on 5/25/2015.
 */
@Controller
@RequestMapping("/book-store")
public class BookStoreController {
    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getBooks() throws IllegalAccessException, InstantiationException {
        List<Book> books = bookService.getBooks();
        ModelAndView modelAndView = new ModelAndView("book-store");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public ModelAndView getDetailOfBook(String id) throws IllegalAccessException, InstantiationException {
        Book book = bookService.getBook(id);
        ModelAndView modelAndView = new ModelAndView("book-detail");
        modelAndView.addObject("book", book);
        return modelAndView;
    }
}
