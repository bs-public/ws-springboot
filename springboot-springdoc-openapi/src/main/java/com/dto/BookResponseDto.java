package com.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response Data Transfer Object for Book information")
public class BookResponseDto {

  @Schema(description = "ID of the book", example = "1")
  private Long id;

  @Schema(description = "Title of the book", example = "Spring Boot in Action")
  private String title;

  @Schema(description = "Author of the book", example = "Craig Walls")
  private String author;

  @Schema(description = "ISBN number of the book", example = "ISBN 9781617292545")
  private String isbn;

  @Schema(description = "Price of the book", example = "50.00")
  private Double price;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

}
