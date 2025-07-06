package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("BookService: Fetching books using BookRepository...");
        bookRepository.getBooks();
        System.out.println("BookService: Book list fetched successfully.");
    }
}
