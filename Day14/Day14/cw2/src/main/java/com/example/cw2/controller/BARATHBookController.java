package com.example.cw2.controller;

import com.example.cw2.model.BARATHBook;
import com.example.cw2.service.BARATHBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BARATHBookController {
    private final BARATHBookService bookService;

    public BARATHBookController(BARATHBookService BookService) {
        this.bookService = BookService;
    }

    @PostMapping
    public ResponseEntity<BARATHBook> createBook(@RequestBody BARATHBook Book) {
        BARATHBook createdBook = bookService.createBook(Book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<BARATHBook>> getAllBooks() {
        List<BARATHBook> Books = bookService.getAllBooks();
        return ResponseEntity.ok(Books);
    }
    @PutMapping("/{bookId}")
    public BARATHBook updateBookById(@PathVariable Long bookId,@RequestBody BARATHBook book){
        BARATHBook b = bookService.updateBookById(bookId, book);
        return b;
    }
    @GetMapping("/{bookId}")
    public BARATHBook getBookById(@PathVariable Long bookId) {
        BARATHBook book = bookService.getBookById(bookId);
        return book;
    }
}
