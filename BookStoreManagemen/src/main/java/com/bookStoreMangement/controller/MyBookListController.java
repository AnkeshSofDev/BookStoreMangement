package com.bookStoreMangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStoreMangement.service.BookListService;

@Controller
public class MyBookListController {
	
	
	@Autowired
	private BookListService booklistservice;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		booklistservice.deleteById(id);
		return "redirect:/my_books";
		
	}

}
