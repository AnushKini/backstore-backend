package com.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.entity.Book;

public interface IBookStoreDAO extends JpaRepository<Book, Long> {
	
//	List<Book> getBooks();
//	Book getBook(int bookId);
//	Book createBook(Book book);
//	Book updateBook(int bookId,Book book);
//	boolean deleteBook(int bookId);

}
