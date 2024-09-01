package com.graphqlserver.input;


public class BookInput {

  public record CreateBookInput(String title, String isbn, createAuthorInput authorInfo) {
  }

  public record createAuthorInput(String firstName, String lastName) {
  }

  public record UpdateBookInput(String title) {
  }

}
