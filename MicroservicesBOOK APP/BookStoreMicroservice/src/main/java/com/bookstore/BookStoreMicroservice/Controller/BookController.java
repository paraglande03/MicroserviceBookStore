package com.bookstore.BookStoreMicroservice.Controller;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookstore.BookStoreMicroservice.dto.BookDTO;
import com.bookstore.BookStoreMicroservice.dto.Response;
import com.bookstore.BookStoreMicroservice.model.Book;
import com.bookstore.BookStoreMicroservice.service.IBookStoreService;

import lombok.val;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/book")
public class BookController {

	@Autowired
	public IBookStoreService bookStoreService;

	@GetMapping("/getBooks")
	public ResponseEntity<Response> getAllBooks() {
		List<Book> booksList = bookStoreService.getAllBooks();
		if (booksList != null)
			return new ResponseEntity<>(new Response("Returned all books successfully", booksList), HttpStatus.OK);
		return new ResponseEntity<>(new Response(".....Don't have any books!!"), HttpStatus.NOT_ACCEPTABLE);
	}


	@PostMapping("/create")
	public ResponseEntity<Response> createBookData(@Valid @RequestBody BookDTO bookDTO) {
		Book booksList = bookStoreService.createBookData(bookDTO);
		return new ResponseEntity<>(new Response("Inserted book data successfully!!", booksList), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<Response> deleteBookDataByBookId(@PathVariable("bookId") UUID bookId) {
		bookStoreService.deleteBookDataByBookId(bookId);
		return new ResponseEntity<>(new Response("Deleted successfully!!", "Deleted id:" + bookId), HttpStatus.OK);
	}

	@GetMapping("/getBook/{bookId}")
	public ResponseEntity<Response> getBookDataByBookId(@PathVariable("bookId") UUID bookId) {
		Book booksList = bookStoreService.getBookDataByBookId(bookId);
		if (booksList != null)
			return new ResponseEntity<>(new Response("Get call for ID successfull", booksList), HttpStatus.OK);
		return new ResponseEntity<>(new Response("Book does not exists!!"), HttpStatus.NOT_ACCEPTABLE);
	}

	@PutMapping("/update/{bookId}")
	public ResponseEntity<Response> updateBookDataByBookId(@PathVariable("bookId") UUID bookId,
			@Valid @RequestBody BookDTO bookDTO) {
		Book booksList = bookStoreService.updateBookDataByBookId(bookId, bookDTO);
		return new ResponseEntity<>(new Response("Updated book data successfully!!", booksList), HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<Response> list() {
		long count = bookStoreService.count();
		return new ResponseEntity<>(new Response("Got count of books successfully!!", count), HttpStatus.OK);
	}


	@GetMapping("/getBookList/{bookName}")
	public ResponseEntity<Response> getBookDataByBookName(@PathVariable("bookName") String bookName) {
		List<Book> books = bookStoreService.getBooksByBookName(bookName);
		if (books != null)
			return new ResponseEntity<>(new Response("Get call for book successfull", books), HttpStatus.OK);
		else
			return new ResponseEntity<>(new Response("Book does not exists!!"), HttpStatus.NOT_ACCEPTABLE);
	}
}