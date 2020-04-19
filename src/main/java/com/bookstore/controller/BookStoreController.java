package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.BookModel;
import com.bookstore.services.IBookStoreService;

@RestController
@CrossOrigin(origins = "*")
public class BookStoreController {

	@Autowired
	private IBookStoreService service;

	@GetMapping("books")
	public ResponseEntity<List<BookModel>> getBooks() {
		List<BookModel> books = service.getBooks();
		System.out.println();
		return new ResponseEntity<>(books, HttpStatus.OK);

	}

	@GetMapping("books/{id}")
	public ResponseEntity<BookModel> getBook(@PathVariable("id") Integer id) {
		BookModel book = service.getBook(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PostMapping("books")
	public ResponseEntity<BookModel> createBook(@RequestBody BookModel book) {
		System.out.println("request recieved = " + book);
		BookModel b = service.createBook(book);
		return new ResponseEntity<>(b, HttpStatus.OK);

	}

	@PutMapping("books/{id}")
	public ResponseEntity<BookModel> updateBook(@PathVariable("id") int id, @RequestBody BookModel book) {
		System.out.println(id);
		System.out.println(book);
		BookModel b = service.updateBook(id, book);
		return new ResponseEntity<>(b, HttpStatus.OK);
	}

	@DeleteMapping("books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
		service.deleteBook(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
