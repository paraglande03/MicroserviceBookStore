package com.bookstore.BookStoreMicroservice.service;

import java.util.List;
import java.util.UUID;

import com.bookstore.BookStoreMicroservice.dto.BookDTO;
import com.bookstore.BookStoreMicroservice.model.Book;

public interface IBookStoreService {

    public List<Book> getAllBooks();

    public Book createBookData(BookDTO bookDTO);

	public Book getBookDataByBookId(UUID bookId);

	public void deleteBookDataByBookId(UUID bookId);

    public Book updateBookDataByBookId(UUID bookId, BookDTO bookDTO);

    long count();

    List<Book> getBooksByBookName(String bookName);

}
