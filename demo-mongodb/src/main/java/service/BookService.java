package service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dao.CrudService;
import domain.entity.Book;
import org.springframework.stereotype.Service;
import util.PropertiesUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by trieu on 19/05/2015.
 */
@Service
public class BookService {

    private CrudService<Book> crudService;

    public BookService(){
        Properties properties = PropertiesUtil.readProperties("db_config.properties");
        String host = properties.getProperty("host");
        int port = Integer.parseInt(properties.getProperty("port"));
        String database = properties.getProperty("database");

        MongoClient mongoClient = new MongoClient(host, port);
        MongoDatabase db = mongoClient.getDatabase(database);

        crudService = new CrudService<Book>(Book.class,db);
    }

    public Book createBook(Book book) throws InstantiationException, IllegalAccessException {
        return crudService.create(book);
    }

    public Book getBook(String id) throws InstantiationException, IllegalAccessException {
        return crudService.get(id);
    }

    public void updateBook(String id, Book book) throws IllegalAccessException{
        book.setId(id);
        crudService.update(book);
    }

    public boolean deleteBook(String id){
        return crudService.delete(id);
    }

    public List<Book> getBooks() throws InstantiationException, IllegalAccessException {
        return crudService.getAll();
    }
}
