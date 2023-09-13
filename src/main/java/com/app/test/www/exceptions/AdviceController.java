package com.app.test.www.exceptions;

import com.app.test.dto.Responses;
import com.app.test.exceptions.CustomExceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class AdviceController {
    @ExceptionHandler(value = CustomExceptions.class)
    public ResponseEntity<Responses> exceptions(CustomExceptions e){
        log.error(e.getMessage());
        return new ResponseEntity<>(Responses.builder()
                .message(e.getMessage())
                .response_code(400)
                .data(null)
                .build(), HttpStatus.BAD_REQUEST);
    }
}
