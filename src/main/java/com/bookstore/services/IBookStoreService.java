package com.bookstore.services;

import java.util.List;

import com.bookstore.model.BookModel;

public interface IBookStoreService {
	
	List<BookModel> getBooks();
	BookModel createBook(BookModel book);
	BookModel updateBook(long bookId, BookModel book);
	BookModel getBook(long bookId);
	void deleteBook(long bookId);

}
