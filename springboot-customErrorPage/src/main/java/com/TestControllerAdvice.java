package com;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class TestControllerAdvice {

  @ExceptionHandler(value = DataNotFoundException.class)
  public ModelAndView handleNotFound() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("not-found");
    return modelAndView;
  }

}
