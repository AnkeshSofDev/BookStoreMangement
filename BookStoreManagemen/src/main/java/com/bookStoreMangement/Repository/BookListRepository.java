package com.bookStoreMangement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStoreMangement.entity.BookList;

public interface BookListRepository extends JpaRepository<BookList, Integer> {

}
