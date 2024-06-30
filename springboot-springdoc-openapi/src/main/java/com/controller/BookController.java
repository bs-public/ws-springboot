package com.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Validated
@Tag(name = "Book Controller", description = "API for managing books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  @Operation(summary = "Get all books", description = "Retrieve a list of all books")
  public ResponseEntity<List<BookResponseDto>> getAllBooks() {
    List<BookResponseDto> books = bookService.getBooks();
    return ResponseEntity.ok(books);
  }

  @PostMapping("/books")
  @Operation(summary = "Create a new book", description = "Add a new book to the library")
  public ResponseEntity<BookResponseDto> createBook(
      @Parameter(description = "Book details for the new book",
          required = true) @Valid @RequestBody BookDto bookDto) {
    BookResponseDto createdBook = bookService.createBook(bookDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
  }

  @GetMapping("/books/{id}")
  @Operation(summary = "Get book by ID", description = "Retrieve a book by its ID")
  public ResponseEntity<BookResponseDto> getBook(@Parameter(
      description = "ID of the book to retrieve", required = true) @PathVariable long id) {
    BookResponseDto book = bookService.getBook(id);
    return ResponseEntity.ok(book);
  }

  @PutMapping("/books/{id}")
  @Operation(summary = "Update book by ID",
      description = "Update the details of an existing book by its ID")
  public ResponseEntity<BookResponseDto> updateBook(
      @Parameter(description = "ID of the book to update", required = true) @PathVariable long id,
      @Parameter(description = "Updated book details",
          required = true) @Valid @RequestBody BookDto bookDto) {
    BookResponseDto updatedBook = bookService.updateBook(id, bookDto);
    return ResponseEntity.ok(updatedBook);
  }

  @DeleteMapping("/books/{id}")
  @Operation(summary = "Delete book by ID",
      description = "Remove a book from the library by its ID")
  public ResponseEntity<Void> deleteBook(
      @Parameter(description = "ID of the book to delete", required = true) @PathVariable long id) {
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
  }
  
}
