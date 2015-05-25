package domain.entity;

import domain.Collection;
import domain.Key;

/**
 * Created by trieudoan on 5/25/2015.
 */
@Collection("comments")
public class Comment extends Entity {
    public static final String BOOK_REF_KEY = "book_id";
    @Key(BOOK_REF_KEY)
    private String bookId;

    @Key("comment")
    private String comment;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
