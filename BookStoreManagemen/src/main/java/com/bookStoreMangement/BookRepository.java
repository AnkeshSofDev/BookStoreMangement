package com.bookStoreMangement;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStoreMangement.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
