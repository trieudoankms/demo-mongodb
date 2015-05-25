package service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dao.CrudService;
import domain.entity.Book;
import domain.entity.Comment;
import org.springframework.stereotype.Service;
import util.PropertiesUtil;

import java.util.List;
import java.util.Properties;

/**
 * Created by trieudoan on 5/25/2015.
 */
@Service
public class CommentService {
    private CrudService<Comment> commentCrudService;

    public CommentService(){
        Properties properties = PropertiesUtil.readProperties("db_config.properties");
        String host = properties.getProperty("host");
        int port = Integer.parseInt(properties.getProperty("port"));
        String database = properties.getProperty("database");

        MongoClient mongoClient = new MongoClient(host, port);
        MongoDatabase db = mongoClient.getDatabase(database);

        commentCrudService = new CrudService<Comment>(Comment.class, db);
    }

    public Comment createComment(Comment comment) throws InstantiationException, IllegalAccessException {
        return commentCrudService.create(comment);
    }

    public Comment getComment(String id) throws InstantiationException, IllegalAccessException {
        return commentCrudService.get(id);
    }

    public void updateComment(String id, Comment comment) throws IllegalAccessException {
        comment.setId(id);
        commentCrudService.update(comment);
    }

    public boolean deleteComment(String id){
        return commentCrudService.delete(id);
    }

    public List<Comment> getCommentsOfBook(String bookId) throws InstantiationException, IllegalAccessException {
        return commentCrudService.find(Comment.BOOK_REF_KEY, bookId);
    }
}
