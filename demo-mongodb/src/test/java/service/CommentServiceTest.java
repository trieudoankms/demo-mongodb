package service;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import domain.entity.Book;
import domain.entity.Comment;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.PropertiesUtil;

import java.util.List;
import java.util.Properties;

/**
 * Created by trieudoan on 5/25/2015.
 */
public class CommentServiceTest extends ServiceTest {
    private CommentService commentService;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        commentService = new CommentService();
    }

    @Test
    public void testCreateAndGetComment() throws IllegalAccessException, InstantiationException {
        Comment comment = new Comment();
        comment.setBookId("bookId1");
        comment.setComment("Comment 1!");
        Comment newComment = commentService.createComment(comment);

        Comment comment1 = commentService.getComment(newComment.getId());

        assertNotNull(newComment);
        assertSameComment(newComment, comment1);
    }

    @Test
    public void testUpdateComment() throws IllegalAccessException, InstantiationException {
        Comment comment = new Comment();
        comment.setBookId("bookId2");
        comment.setComment("Comment 2!");

        comment = commentService.createComment(comment);

        // update comment
        comment.setComment("Comment 2 is updated!");
        commentService.updateComment(comment.getId(), comment);

        Comment updatedComment = commentService.getComment(comment.getId());

        assertSameComment(comment, updatedComment);

    }

    @Test
    public void testDeleteComment() throws IllegalAccessException, InstantiationException {
        Comment comment = new Comment();
        comment.setBookId("bookId3");
        comment.setComment("Comment 3!");

        comment = commentService.createComment(comment);

        //delete comment
        boolean deleteResult = commentService.deleteComment(comment.getId());
        //try find deleted comment
        Comment deletedComment = commentService.getComment(comment.getId());

        assertTrue(deleteResult);
        assertNull(deletedComment);
    }

    @Test
    public void testGetCommentsOfBook() throws IllegalAccessException, InstantiationException {
        Comment comment4 = new Comment();
        comment4.setBookId("bookId_test_get_comments");
        comment4.setComment("Comment 4!");
        comment4 = commentService.createComment(comment4);

        Comment comment5 = new Comment();
        comment5.setBookId("bookId_test_get_comments");
        comment5.setComment("Comment 5!");
        comment5 = commentService.createComment(comment5);

        Comment comment6 = new Comment();
        comment6.setBookId("bookId_test_get_comments");
        comment6.setComment("Comment 6!");
        comment6 = commentService.createComment(comment6);

        List<Comment> comments = commentService.getCommentsOfBook("bookId_test_get_comments");
        assertEquals(3, comments.size());
    }

    private void assertSameComment(Comment expectedComment, Comment actualComment) {
        assertEquals(expectedComment.getId(), actualComment.getId());
        assertEquals(expectedComment.getBookId(), actualComment.getBookId());
        assertEquals(expectedComment.getComment(), actualComment.getComment());
    }
}