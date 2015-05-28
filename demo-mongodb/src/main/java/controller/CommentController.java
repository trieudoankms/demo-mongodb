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

    @RequestMapping(value = "/{bookId}/{startPosition}/{number}", method = RequestMethod.GET)
    public @ResponseBody List<Comment> getCommentsOfBook(@PathVariable String bookId, @PathVariable int startPosition, @PathVariable int number) throws IllegalAccessException, InstantiationException {
        List<Comment> comments = commentService.getCommentsOfBook(bookId, startPosition, number);
        return comments;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Comment addComment(@RequestBody Comment comment) throws IllegalAccessException, InstantiationException {
        Comment newComment = commentService.createComment(comment);
        return newComment;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteComment(@PathVariable String id){
        System.out.print("COMMENT ID: " + id);
        return commentService.deleteComment(id);
    }
}
