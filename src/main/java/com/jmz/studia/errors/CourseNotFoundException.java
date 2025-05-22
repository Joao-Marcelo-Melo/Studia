package com.jmz.studia.errors;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException() {
    super("Course Not Found.");
  }
}
