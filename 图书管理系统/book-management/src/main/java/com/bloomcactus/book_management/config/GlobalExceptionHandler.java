package com.bloomcactus.book_management.config;

import com.bloomcactus.book_management.exception.BookNotFoundException;
import com.bloomcactus.book_management.entity.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.springframework.validation.FieldError;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 处理所有未知的异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 处理找不到图书的异常
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // 处理验证错误
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldError();
        String defaultMessage = fieldError != null ? fieldError.getDefaultMessage() : "Unknown error";
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Error", defaultMessage);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}