package com.bookStoreMangement.service;

import java.util.List;

import com.bookStoreMangement.entity.BookList;

public interface BookListService {
	
	void saveBookList(BookList book);
    List<BookList> getAllMyBook();
    void deleteById(int id);
}
