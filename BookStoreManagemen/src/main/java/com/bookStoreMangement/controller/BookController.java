package com.bookStoreMangement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.bookStoreMangement.entity.Book;
import com.bookStoreMangement.entity.BookList;
import com.bookStoreMangement.entity.Email;
import com.bookStoreMangement.service.BookListService;
import com.bookStoreMangement.service.BookService;
import com.bookStoreMangement.service.EmailService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookListService bookListService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public String HomePage() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String BookRegisterPage() {
		return "register";
	}
	
	//ModelAndView is a return method which send data to controller to view
	@GetMapping("/avilabe_book")
	public ModelAndView AvilableBookListPage() {
		 List<Book> list = bookService.getAllBooks();
		return  new ModelAndView ("booklist","book",list);
	}
	
	//@ModelAttribute is used to send the data from view to controller
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookService.saveBook(b);
		return "redirect:/avilabe_book";		
	}
	
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<BookList> allMyBooklist = bookListService.getAllMyBook();
		model.addAttribute("book", allMyBooklist);
		return "myBooks";
		
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bookService.getBookById(id);
	  BookList bl = new BookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		bookListService.saveBookList(bl);
		return "redirect:/my_books";
		
	}
	
	
	@RequestMapping("/editbooks/{id}")
	public String editBook(@PathVariable("id") int id , Model model) {
		Book b = bookService.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
		
	}
	
	@RequestMapping("/deletebooks/{id}")
	public String deleteBooks(@PathVariable("id") int id ) {
		bookService.deleteById(id);
		return "redirect:/avilabe_book";
		
	}
	
	@GetMapping("/contact_us")
	public String ContactPage() {
		return "contact";
	}
	
	
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute Email email ,HttpSession session) {
		
		emailService.SendMail(email);
		session.setAttribute("msg", "Email send Succesfully");
		
		return "redirect:/contact_us";
		
	}

}
