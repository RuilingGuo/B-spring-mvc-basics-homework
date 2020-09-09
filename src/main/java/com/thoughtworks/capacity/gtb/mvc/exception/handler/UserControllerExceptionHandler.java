package com.thoughtworks.capacity.gtb.mvc.exception.handler;

import com.thoughtworks.capacity.gtb.mvc.exception.RegisterUserFailedException;
import com.thoughtworks.capacity.gtb.mvc.exception.error.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Slf4j
@ControllerAdvice
public class UserControllerExceptionHandler {

    @ExceptionHandler(RegisterUserFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleHttpException(RegisterUserFailedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body(new ErrorMessage(ex.getMessage()));
    }

}
