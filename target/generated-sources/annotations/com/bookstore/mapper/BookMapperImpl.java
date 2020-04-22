package com.bookstore.mapper;

import com.bookstore.entity.Book;
import com.bookstore.model.BookModel;
import com.bookstore.model.BookModel.BookModelBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-22T18:49:53+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookModel toBookModel(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookModelBuilder bookModel = BookModel.builder();

        bookModel.id( entity.getId() );
        bookModel.name( entity.getName() );
        bookModel.author( entity.getAuthor() );
        bookModel.publication( entity.getPublication() );
        bookModel.category( entity.getCategory() );
        bookModel.price( entity.getPrice() );

        return bookModel.build();
    }

    @Override
    public Book toBookEntity(BookModel model) {
        if ( model == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( model.getId() );
        book.setName( model.getName() );
        book.setAuthor( model.getAuthor() );
        book.setPublication( model.getPublication() );
        book.setCategory( model.getCategory() );
        book.setPrice( model.getPrice() );

        return book;
    }
}
