package com.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

	private long id;
	private String name;
	private String author;
	private String publication;
	private String category;
	private int price;
}
