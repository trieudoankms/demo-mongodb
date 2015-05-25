package controller;

import domain.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CommentService;

import java.util.List;

/**
 * Created by trieudoan on 5/25/2015.
 */
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public List<Comment> getCommentsOfBook(@PathVariable String bookId) throws IllegalAccessException, InstantiationException {
        List<Comment> comments = commentService.getCommentsOfBook(bookId);
        return comments;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment) throws IllegalAccessException, InstantiationException {
        Comment newComment = commentService.createComment(comment);
        return newComment;
    }
}
