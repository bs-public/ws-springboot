package com.util;

import org.springframework.stereotype.Component;
import com.dto.BookDto;
import com.dto.BookResponseDto;
import com.entity.Book;

@Component
public class BookMapper {

  public Book toEntity(BookDto bookDto) {
    Book book = new Book();
    book.setTitle(bookDto.getTitle());
    book.setAuthor(bookDto.getAuthor());
    book.setIsbn(bookDto.getIsbn());
    book.setPrice(bookDto.getPrice());
    return book;
  }

  public BookResponseDto toResponseDto(Book book) {
    BookResponseDto responseDto = new BookResponseDto();
    responseDto.setId(book.getId());
    responseDto.setTitle(book.getTitle());
    responseDto.setAuthor(book.getAuthor());
    responseDto.setIsbn(book.getIsbn());
    responseDto.setPrice(book.getPrice());
    return responseDto;
  }

  public void updateBookFromDto(BookDto bookDto, Book book) {
    book.setTitle(bookDto.getTitle());
    book.setAuthor(bookDto.getAuthor());
    book.setIsbn(bookDto.getIsbn());
    book.setPrice(bookDto.getPrice());
  }

}
