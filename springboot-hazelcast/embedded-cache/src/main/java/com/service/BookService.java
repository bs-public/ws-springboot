package com.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.config.Caches;

@Service
public class BookService {

  @Cacheable(value = Caches.DEFAULT_CACHE_NAME, key = "#isbn")
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
