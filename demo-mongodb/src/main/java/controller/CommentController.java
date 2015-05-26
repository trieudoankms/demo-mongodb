package controller;

import domain.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CommentService;

import java.awt.*;
import java.util.List;

/**
 * Created by trieudoan on 5/25/2015.
 */
@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public @ResponseBody List<Comment> getCommentsOfBook(@PathVariable String bookId) throws IllegalAccessException, InstantiationException {
        List<Comment> comments = commentService.getCommentsOfBook(bookId);
        return comments;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Comment addComment(@RequestBody Comment comment) throws IllegalAccessException, InstantiationException {
        Comment newComment = commentService.createComment(comment);
        return newComment;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Comment hello(){
        Comment comment = new Comment();
        comment.setComment("Hello world!");
        comment.setBookId("bookId1");
        comment.setId("commentId1");
        return comment;
    }
}
