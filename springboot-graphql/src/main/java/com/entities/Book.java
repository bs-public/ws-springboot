package com.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "title", nullable = false, length = 255)
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id", nullable = false)
  private Author author;

  @Column(name = "published_date")
  private LocalDate publishedDate;

  @Column(name = "isbn", unique = true, length = 13)
  private String isbn;

  @Column(name = "pages")
  private Integer pages;

  @Column(name = "language", length = 50)
  private String language;

  @Column(name = "publisher", length = 255)
  private String publisher;

  @Column(name = "genre", length = 100)
  private String genre;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public LocalDate getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishedDate="
        + publishedDate + ", isbn=" + isbn + ", pages=" + pages + ", language=" + language
        + ", publisher=" + publisher + ", genre=" + genre + ", createdAt=" + createdAt
        + ", updatedAt=" + updatedAt + "]";
  }

}
