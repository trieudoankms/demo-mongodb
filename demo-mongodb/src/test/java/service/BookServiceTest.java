package service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import domain.entity.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.BookService;
import util.PropertiesUtil;

import java.util.Arrays;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by trieu on 19/05/2015.
 */
public class BookServiceTest extends ServiceTest {

    private BookService bookService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        bookService = new BookService();
    }

    @Test
    public void testCreateBook() throws Exception {
        Book newBook = createBook("Java ABC", "Aaa", 100, "Java", "Programing");
        Book savedBook = bookService.createBook(newBook);

        assertSameBook(newBook, savedBook);
    }

    @Test
    public void testGetBook() throws IllegalAccessException, InstantiationException {
        // Create a new book and save to database
        Book newBook = createBook("C#", "Author ab", 200, "C#", "Programing");
        String id = bookService.createBook(newBook).getId();

        // Get the book we saved recently
        Book book = bookService.getBook(id);

        assertSameBook(newBook, book);
    }

    @Test
    public void testUpdateBook() throws IllegalAccessException, InstantiationException {
        // Create a new book and save to database
        Book newBook = createBook("Android Dev Tutorials", "Hacker", 50, "android", "Programing");
        Book book = bookService.createBook(newBook);

        // Change info of this book and update database
        book.setAuthor("Hacker 123");
        book.setPrice(10);
        bookService.updateBook(book.getId(), book);

        // Get the book we saved recently
        Book savedBook = bookService.getBook(book.getId());

        assertSameBook(book, savedBook);

    }

    @Test
    public void testDeleteBook() throws IllegalAccessException, InstantiationException{
        // Create a new book and save to database
        Book newBook = createBook("Delete data", "Hacker", 50, "delete", "Programing");
        String id = bookService.createBook(newBook).getId();

        // Delete the book we saved recently
        boolean deleteResult = bookService.deleteBook(id);

        // Get book by id of the book deleted
        Book deletedBook = bookService.getBook(id);

        assertTrue(deleteResult);
        assertNull(deletedBook);

    }

    private Book createBook(String name, String author, int price, String... tags){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.setTags(Arrays.asList(tags));
        return book;
    }

    private void assertSameBook(Book expectedBook, Book actualBook){
        assertEquals(expectedBook.getName(), actualBook.getName());
        assertEquals(expectedBook.getAuthor(), actualBook.getAuthor());
        assertEquals(expectedBook.getPrice(), actualBook.getPrice());
        assertArrayEquals(expectedBook.getTags().toArray(), actualBook.getTags().toArray());
    }
}