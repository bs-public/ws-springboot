package com.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Cacheable(cacheNames = "books", key = "#isbn")
  public String getBookNameByIsbn(String isbn) {
    return findBookInSlowSource(isbn);
  }

  private String findBookInSlowSource(String isbn) {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
    return "Test Book";
  }
}
