package com.example.cw2.service;

import com.example.cw2.model.BARATHBook;
import com.example.cw2.repository.BARATHBookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BARATHBookService {
    private final BARATHBookRepo bookRepo;

    public BARATHBookService(BARATHBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BARATHBook createBook(BARATHBook Book) {
        return bookRepo.save(Book);
    }
    public List<BARATHBook> getAllBooks() {
        return bookRepo.findAll();
    }
    public BARATHBook getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    public BARATHBook updateBookById(Long id,BARATHBook book){
        BARATHBook b = bookRepo.findById(id).orElse(null);
        if(b!=null){
            b.setAuthor(book.getAuthor());
            b.setAvailableCopies(book.getAvailableCopies());
            b.setTitle(book.getTitle());
            b.setTotalCopies(book.getTotalCopies());
            bookRepo.save(b);
        }
        return b;
    }
}
