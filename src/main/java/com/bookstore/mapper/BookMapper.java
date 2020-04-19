package com.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.bookstore.entity.Book;
import com.bookstore.model.BookModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {
	
	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
	
    BookModel toBookModel(Book entity);
    
    Book toBookEntity(BookModel model);
}
