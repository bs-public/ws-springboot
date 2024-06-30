package com.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.BookDto;
import com.dto.BookResponseDto;
import com.entity.Book;
import com.exception.BookNotFoundException;
import com.repository.BookRepository;
import com.util.BookMapper;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private BookMapper bookMapper;

  public List<BookResponseDto> getBooks() {
    return bookRepository.findAll().stream().map(bookMapper::toResponseDto)
        .collect(Collectors.toList());
  }

  public BookResponseDto createBook(BookDto bookDto) {
    Book book = bookMapper.toEntity(bookDto);
    Book savedBook = bookRepository.save(book);
    return bookMapper.toResponseDto(savedBook);
  }

  public BookResponseDto getBook(long id) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    return bookMapper.toResponseDto(book);
  }

  public BookResponseDto updateBook(long id, BookDto bookDto) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    bookMapper.updateBookFromDto(bookDto, book);
    Book updatedBook = bookRepository.save(book);
    return bookMapper.toResponseDto(updatedBook);
  }

  public void deleteBook(long id) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    bookRepository.delete(book);
  }

}
