package com.training.jparepository.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.training.jparepository.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("RESOURCE_NOT_FOUND", details);
	        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(StartEndDateException.class)
	    public final ResponseEntity<Object> handleStartEndDateException(StartEndDateException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("IVALID_DATES", details);
	        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	    }
	 
	 @ExceptionHandler(ResourceAlreadyExistsException.class)
	    public final ResponseEntity<Object> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("ALREADY_EXISTS", details);
	        return new ResponseEntity<Object>(error, HttpStatus.CONFLICT);
	        
	    }
	 
	 @ExceptionHandler(MethodArgumentTypeMismatchException.class)
	    public final ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add("Invalid Format");
	        ErrorResponse error = new ErrorResponse("INVALID_FORMAT", details);
	        return new ResponseEntity<Object>(error, HttpStatus.CONFLICT);
	    }
	 
	 @ExceptionHandler(Exception.class)
	    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("SERVER_ERROR", details);
	        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	 
	
}
