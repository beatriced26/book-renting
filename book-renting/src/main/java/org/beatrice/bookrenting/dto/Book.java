package org.beatrice.bookrenting.dto;

import java.time.LocalDate;

public class Book {

    private int refId;
    private String title;
    private String author;
    private LocalDate publishDate;
    private boolean rented;

    public Book(int refId, String title, String author, LocalDate publishDate, boolean rented) {
        this.refId = refId;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.rented = rented;
    }

    public int getRefId() {
        return refId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
