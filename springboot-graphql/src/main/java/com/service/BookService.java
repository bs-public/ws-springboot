package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.entities.Book;
import com.repositories.BookRepository;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public Book create(Book book) {
    return bookRepository.save(book);
  }

  public Book getOne(Long id) {
    return bookRepository.findById(id).orElse(null);
  }

  public List<Book> getAll() {
    return bookRepository.findAll();
  }

  public Book update(Book book) {
    return bookRepository.saveAndFlush(book);
  }

  public void delete(Long id) {
    bookRepository.deleteById(id);
  }

  public long getTotal() {
    return bookRepository.count();
  }

  public Page<Book> findAllPaginate(Pageable pageable) {
    return bookRepository.findAll(pageable);
  }

}
