package entity;

import entity.Entity;
import domain.Collection;
import domain.Key;

import java.util.List;

/**
 * Created by trieu on 19/05/2015.
 */
@Collection("books")
public class Book extends Entity {

    @Key("name")
    private String name;

    @Key("author")
    private String author;

    @Key("price")
    private int price;

    @Key("tags")
    private List<String> tags;

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
