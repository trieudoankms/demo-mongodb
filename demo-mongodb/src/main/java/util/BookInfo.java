package util;

import domain.entity.Book;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trieu on 24/05/2015.
 */
public class BookInfo {
    private String id;
    private String name;
    private String author;
    private int price;
    private String tags;

    public BookInfo(){}

    public BookInfo(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.price = book.getPrice();
        List<String> listTag = book.getTags();
        if(listTag != null && !listTag.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append(listTag.get(0));
            for(int i = 1; i < listTag.size(); i++){
                builder.append(",");
                builder.append(listTag.get(i));
            }

            this.tags = builder.toString();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Book toBookEntity(){
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        if(!StringUtils.isEmpty(tags)) {
            List<String> listTags = new ArrayList<String>();
            for (String tag : tags.split(",")) {
                listTags.add(tag);
            }
            book.setTags(listTags);
        }

        return book;
    }


}
