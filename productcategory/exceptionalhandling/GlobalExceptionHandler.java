package com.productcategory.exceptionalhandling;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorResponse>handleCategoryNotFound(CategoryNotFoundException ex){
		return ResponseEntity.status(404)
				.body(new ErrorResponse(404, ex.getMessage()));
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse>handleValidation(MethodArgumentNotValidException ex){
		String msg=ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(e->e.getField()+":"+e.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
		return ResponseEntity.status(400)
				.body(new ErrorResponse(400, msg));
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse>handleOthers(Exception ex){
		return ResponseEntity.status(500)
				.body(new ErrorResponse(500, "unexpected error" +ex.getMessage()));
	}

}
