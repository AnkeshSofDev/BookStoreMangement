package com.bookStoreMangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStoreMangement.Repository.BookListRepository;
import com.bookStoreMangement.entity.BookList;

@Service
public class BookListServiceImpl implements BookListService {
	
	@Autowired
	private BookListRepository bookListRepo;

	@Override
	public void saveBookList(BookList book) {
		bookListRepo.save(book);
		
	}

	@Override
	public List<BookList> getAllMyBook() {	
		return bookListRepo.findAll();
	}

	@Override
	public void deleteById(int id) {
		bookListRepo.deleteById(id);
		
	}

}
