package com.bookstore.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.IBookStoreDAO;
import com.bookstore.entity.Book;
import com.bookstore.mapper.BookMapper;
import com.bookstore.model.BookModel;

@Service
public class BookStoreService implements IBookStoreService {

	@Autowired
	private IBookStoreDAO dao;

	@Autowired
	private BookMapper mapper;

	@Override
	public List<BookModel> getBooks() {
		List<Book> bookEntities = dao.findAll();
		return bookEntities.stream().map(x -> mapper.toBookModel(x)).collect(Collectors.toList());
	}

	@Override
	public BookModel createBook(BookModel bookModel) {
		Book bookEntity = mapper.toBookEntity(bookModel);
		return mapper.toBookModel(dao.save(bookEntity));
	}

	@Override
	public BookModel updateBook(long bookId, BookModel book) {
		Optional<Book> bookEntity = dao.findById(bookId);
		if (bookEntity == null) {
		} else {
			bookEntity.get().setName(book.getName());
			bookEntity.get().setAuthor(book.getAuthor());
			bookEntity.get().setCategory(book.getCategory());
			bookEntity.get().setPublication(book.getPublication());
			bookEntity.get().setPrice(book.getPrice());
		}
		return mapper.toBookModel(dao.save(bookEntity.get()));
	}

	@Override
	public BookModel getBook(long bookId) {
		Optional<Book> bookEntity = dao.findById(bookId);
		return mapper.toBookModel(bookEntity.get());
	}

	@Override
	public void deleteBook(long bookId) {
		dao.deleteById(bookId);
	}

}
