package com.nummapper.nummap.globalexeption;

import com.nummapper.nummap.contenttemplates.exceptions.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {DataNotFoundException.class})
  public ResponseEntity<String> DataNotFoundException(DataNotFoundException ex) {
    log.error("Application exception: " + ex.getMessage());
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}