package com.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.controller.BookController;
import com.model.Book;

public class BookModel extends EntityModel<Book> {

  public BookModel(Book book) {
    super(book);
    final long id = book.getId();

    add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBook(id))
        .withSelfRel());
    add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).deleteBook(id))
        .withRel("delete"));
    add(WebMvcLinkBuilder
        .linkTo(WebMvcLinkBuilder.methodOn(BookController.class).updateBook(id, book))
        .withRel("update"));
    add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks())
        .withRel("all-books"));
  }

}
