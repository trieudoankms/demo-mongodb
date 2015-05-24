package controller;

import domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;
import util.BookInfo;

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

    @RequestMapping(method = RequestMethod.GET, value = "/add-new")
    public ModelAndView openAddNewBookPage() {
        ModelAndView modelAndView = new ModelAndView("book-add");
        modelAndView.addObject("book", new BookInfo());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addBook")
    public ModelAndView addBook(@ModelAttribute("book") BookInfo bookInfo, BindingResult result) throws IllegalAccessException, InstantiationException {
        Book book = bookInfo.toBookEntity();
        Book newBook = bookService.createBook(book);
        if (newBook != null) {
            return new ModelAndView("redirect:/books.do");
        } else {
            ModelAndView modelAndView = new ModelAndView("book-add");
            modelAndView.addObject("book", book);
            return modelAndView;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public ModelAndView openUpdateBookPage(String id) throws IllegalAccessException, InstantiationException {
        Book book = bookService.getBook(id);
        if(book != null) {
            ModelAndView modelAndView = new ModelAndView("book-update");
            modelAndView.addObject("book", new BookInfo(book));
            return modelAndView;
        }

        return new ModelAndView("redirect:/error.do");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateBook")
    public ModelAndView updateBook(@ModelAttribute("book") BookInfo bookInfo, BindingResult result) throws IllegalAccessException, InstantiationException {
        Book book = bookInfo.toBookEntity();
        bookService.updateBook(book.getId(), book);
        return new ModelAndView("redirect:/books.do");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteBook")
    public ModelAndView deleteBook(String id){
        bookService.deleteBook(id);
        return new ModelAndView("redirect:/books.do");
    }
}
