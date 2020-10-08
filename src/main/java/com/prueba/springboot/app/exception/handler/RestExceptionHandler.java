package com.prueba.springboot.app.exception.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prueba.springboot.app.exception.ClienteEmailNotFoundException;
import com.prueba.springboot.app.exception.ClienteFieldAlreadyExistException;
import com.prueba.springboot.app.exception.ProductFieldAlreadyExistException;
import com.prueba.springboot.app.exception.ProductoIdNotFoundException;
import com.prueba.springboot.app.exception.VentaFieldAlreadyExistException;
import com.prueba.springboot.app.exception.VentaIdNotFoundException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class,ClienteFieldAlreadyExistException.class,ProductFieldAlreadyExistException.class,
    	VentaFieldAlreadyExistException.class})
    protected ResponseEntity<?> handleEntityNotFound(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setCode("400");
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler({ProductoIdNotFoundException.class, VentaIdNotFoundException.class,
    	ClienteEmailNotFoundException.class})
    protected ResponseEntity<?> handleEntityExists(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        apiError.setCode("404");
        return buildResponseEntity(apiError);
    }


    private ResponseEntity<?> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}