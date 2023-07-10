package com.bookStoreMangement.service;

import java.util.List;

import com.bookStoreMangement.entity.Book;

public interface BookService {
	
	void saveBook(Book b);
	List<Book> getAllBooks();
	Book getBookById(int id);
	void deleteById(int id);

}
