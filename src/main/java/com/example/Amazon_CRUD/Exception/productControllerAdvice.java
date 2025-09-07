package com.example.Amazon_CRUD.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class productControllerAdvice {

    public ResponseEntity<?> DuplicateRecordException(duplicateRecord ex) {
        return ResponseEntity.status(409).body(ex.getMessage());
    }
}
