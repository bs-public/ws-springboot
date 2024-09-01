package com.graphqlserver;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.entities.Author;
import com.entities.Book;
import com.graphqlserver.input.BookInput.CreateBookInput;
import com.graphqlserver.input.BookInput.UpdateBookInput;
import com.service.BookService;

@Controller
public class BookController {

  @Autowired
  private BookService bookService;

  @QueryMapping
  public List<Book> getBooks() {
    return bookService.getAll();
  }

  @QueryMapping
  public Book getBook(@Argument long id) {
    return bookService.getOne(id);
  }

  @MutationMapping
  public Book addBook(@Argument CreateBookInput bookInfo) {
    Book newBook = new Book();
    newBook.setTitle(bookInfo.title());
    newBook.setIsbn(bookInfo.isbn());

    Author author = new Author();
    author.setFirstName(bookInfo.authorInfo().firstName());
    author.setLastName(bookInfo.authorInfo().lastName());
    newBook.setAuthor(author);

    Book book = bookService.create(newBook);
    return book;
  }

  @MutationMapping
  public Book updateBook(@Argument long id, @Argument UpdateBookInput bookInfo) {
    Book book = bookService.getOne(id);
    book.setTitle(bookInfo.title());
    return bookService.update(book);
  }

  @MutationMapping
  public long deleteBook(@Argument long id) {
    bookService.delete(id);
    return id;
  }

}


