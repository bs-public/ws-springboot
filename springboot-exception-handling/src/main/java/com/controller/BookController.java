package com.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dto.BookDto;
import com.dto.BookResponseDto;
import com.service.BookService;

@RestController
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public ResponseEntity<List<BookResponseDto>> getAllBooks() {
    List<BookResponseDto> books = bookService.getBooks();
    return ResponseEntity.ok(books);
  }

  @PostMapping("/books")
  public ResponseEntity<BookResponseDto> createBook(@RequestBody BookDto bookDto) {
    BookResponseDto createdBook = bookService.createBook(bookDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
  }

  @GetMapping("/books/{id}")
  public ResponseEntity<BookResponseDto> getBook(@PathVariable long id) {
    BookResponseDto book = bookService.getBook(id);
    return ResponseEntity.ok(book);
  }

  @PutMapping("/books/{id}")
  public ResponseEntity<BookResponseDto> updateBook(@PathVariable long id,
      @RequestBody BookDto bookDto) {
    BookResponseDto updatedBook = bookService.updateBook(id, bookDto);
    return ResponseEntity.ok(updatedBook);
  }

  @DeleteMapping("/books/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable long id) {
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
  }

}
