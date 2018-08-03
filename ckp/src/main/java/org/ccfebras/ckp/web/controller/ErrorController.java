package org.ccfebras.ckp.web.controller;

import org.ccfebras.ckp.exception.NotFoundException;
import org.ccfebras.ckp.web.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ApiResponse> handleNotFound(NotFoundException ex) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                ex.getMessage()
                ), HttpStatus.NOT_FOUND);
    }
}
