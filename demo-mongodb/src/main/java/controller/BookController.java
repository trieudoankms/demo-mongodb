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
 * Created by trieudoan on 5/22/2015.
 */
@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getBooks() throws IllegalAccessException, InstantiationException {
        List<Book> books = bookService.getBooks();
        ModelAndView modelAndView = new ModelAndView("books");
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
