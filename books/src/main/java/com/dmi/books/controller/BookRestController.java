package com.dmi.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmi.books.dao.BookDAO;
import com.dmi.books.model.Book;

@RestController
public class BookRestController {

	@Autowired
	private BookDAO bookDAO;

	@GetMapping("/items")
	public List<Book> getBooks() {
		
		List<Book> list = bookDAO.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/items/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {

		Book book = bookDAO.getObj(id);
		if (book == null) {
			return new ResponseEntity("No Book found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(book, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/items")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {

		try {
			bookDAO.create(book);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity(book, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/items/{id}")
	public ResponseEntity deleteBook(@PathVariable Long id) {

		try {
			if (!bookDAO.delete(id)) {
				return new ResponseEntity("No Book found for ID " + id, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/items/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {

		try {
			if (!bookDAO.update(book)) {
				return new ResponseEntity("No Book found for ID " + id, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity(book, HttpStatus.OK);
	}


}
