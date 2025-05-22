package com.jmz.studia.errors;

public class ModuleNotFoundException extends RuntimeException {
  public ModuleNotFoundException() {
    super("Module not found");
  }
}
