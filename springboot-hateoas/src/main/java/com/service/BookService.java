package com.service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import com.hateoas.BookModel;
import com.model.Book;

@Service
public class BookService {

  private final Map<Long, Book> books = new ConcurrentHashMap<>();

  public BookService() {
    books.put(1L, new Book(1L, "Book1", "Author1"));
    books.put(2L, new Book(2L, "Book2", "Author2"));
  }

  public Collection<EntityModel<Book>> getBooks() {
    return books.values().stream().map(BookModel::new).collect(Collectors.toList());
  }

  public BookModel getBook(long id) {
    Book book = books.get(id);
    return new BookModel(book);
  }

  public EntityModel<Book> createBook(Book book) {
    books.put(book.getId(), book);
    return new BookModel(book);
  }

  public EntityModel<Book> updateBook(long id, Book book) {
    book.setId(id);
    books.put(id, book);
    return new BookModel(book);
  }

  public Book deleteBook(long id) {
    return books.remove(id);
  }

}
