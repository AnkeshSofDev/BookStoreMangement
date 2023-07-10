package com.bookStoreMangement.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStoreMangement.BookRepository;
import com.bookStoreMangement.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bRepo;

	@Override
	public void saveBook(Book b) {
		bRepo.save(b);
		
	}

	@Override
	public List<Book> getAllBooks() {
		return bRepo.findAll();
	}

	@Override
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		bRepo.deleteById(id);
		
	}
	
	

}
