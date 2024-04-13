package com.controller;

import java.util.Collection;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Book;
import com.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/")
  public Collection<EntityModel<Book>> getAllBooks() {
    return bookService.getBooks();
  }

  @PostMapping("/")
  public EntityModel<Book> createBook(@RequestBody Book book) {
    return bookService.createBook(book);
  }

  @PutMapping("/{id}")
  public EntityModel<Book> updateBook(@PathVariable long id, @RequestBody Book book) {
    return bookService.updateBook(id, book);
  }

  @GetMapping("/{id}")
  public EntityModel<Book> getBook(@PathVariable long id) {
    return bookService.getBook(id);
  }

  @DeleteMapping("/{id}")
  public Book deleteBook(@PathVariable long id) {
    return bookService.deleteBook(id);
  }

}
