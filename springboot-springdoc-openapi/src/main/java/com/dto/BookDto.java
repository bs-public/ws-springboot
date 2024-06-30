package com.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Data Transfer Object for Book information")
public class BookDto {

  @NotNull
  @Schema(description = "Title of the book", example = "Spring Boot in Action")
  private String title;

  @NotNull
  @Schema(description = "Author of the book", example = "Craig Walls")
  private String author;

  @NotNull
  @Schema(description = "ISBN number of the book", example = "ISBN 9781617292545")
  private String isbn;

  @NotNull
  @Schema(description = "Price of the book", example = "50.00")
  private Double price;

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
