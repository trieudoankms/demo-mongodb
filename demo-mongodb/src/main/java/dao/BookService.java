package dao;

import com.mongodb.client.MongoDatabase;
import entity.Book;

/**
 * Created by trieu on 19/05/2015.
 */
public class BookService {

    private CrudService<Book> crudService;

    public BookService(MongoDatabase db){
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
}
