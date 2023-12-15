package org.beatrice.bookrenting.services;

import org.beatrice.bookrenting.dto.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.LocalDate.*;

@Service
public class BookService {

    private static final List<Book> BOOKS_AVAILABLE = new ArrayList<>();

    static {
        BOOKS_AVAILABLE.add(new Book(1, "Book1", "Author1",
                of(2010, 8, 12), true));

        BOOKS_AVAILABLE.add(new Book(1, "Book2", "Author1",
                of(1987, 7, 2), false));

        BOOKS_AVAILABLE.add(new Book(1, "Book3", "Author2",
                of(2010, 1, 29), true));

        BOOKS_AVAILABLE.add(new Book(2, "Book4", "Author2",
                of(1995, 6, 26), true));

        BOOKS_AVAILABLE.add(new Book(3, "Book5", "Author3",
                of(2001, 10, 2), false));

        BOOKS_AVAILABLE.add(new Book(4, "Book6", "Author4",
                of(1945, 11, 22), true));
    }

    public List<Book> getBooksAvailable() {
        return BOOKS_AVAILABLE;
    }

    public Book getBookByTitle(String title) {
        return BOOKS_AVAILABLE.stream()
                .filter(book -> title.equals(book.getTitle()))
                .findFirst()
                .orElseThrow();

    }

    public boolean rentBook(int bookId) {
        for (Book book : BOOKS_AVAILABLE) {
            if (book.getRefId() == bookId && !book.isRented()) {
                book.setRented(true);
                return true;
            }
        }
        return false;
    }

    public Book getBookPublishedBefore2000(LocalDate date) {
        LocalDate year2000 = LocalDate.of(2000, 01,01);

        List<Book> booksBeforeYear2000 = BOOKS_AVAILABLE.stream()
                .filter(book -> book.getPublishDate().isBefore(year2000))
                .collect(Collectors.toList());

        return (Book) booksBeforeYear2000;
    }

    public Book deleteBookByAuthor(String author) {
        Optional<Book> bookToRemove = BOOKS_AVAILABLE.stream()
                .filter(book -> author.equals(book.getAuthor()))
                .findFirst();

        if (bookToRemove.isPresent()) {
            Book removedBook = bookToRemove.get();
            BOOKS_AVAILABLE.remove(removedBook);
            return removedBook;
        }else {
            throw new NoSuchElementException("Book not found");
        }


    }
}
