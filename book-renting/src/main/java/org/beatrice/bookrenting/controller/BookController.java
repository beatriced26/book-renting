package org.beatrice.bookrenting.controller;

import org.beatrice.bookrenting.dto.Book;
import org.beatrice.bookrenting.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")

public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks () {
        return bookService.getBooksAvailable();
    }

    @GetMapping("/{title}")
    public Book getBookByTitle (@PathVariable("title") String title) {
        return bookService.getBookByTitle(title);
    }


    @PostMapping("/rent/{bookId}")
    public String rentBook (@PathVariable ("bookId")int bookId) {
        boolean rented = bookService.rentBook(bookId);

        if (rented) {
            return "Book is not available for renting.";
        }else {
            return "Book is available for renting.";
        }
    }

    @GetMapping("/published-before-2000/{date}")
    public Book getBookPublishedBefore2000 (@PathVariable ("published-before-2000") LocalDate date) {
        return bookService.getBookPublishedBefore2000(date);
    }

    @DeleteMapping ("/deletion/{author}")
    public String deleteBookByAuthor (@PathVariable ("author") String author) {
        bookService.deleteBookByAuthor(author);
        return ("Book by " + author + " was deleted");
    }

}
