package br.com.hellosol.hellosol.exception.handler;

import br.com.hellosol.hellosol.dto.error.ErrorResponseDTO;
import br.com.hellosol.hellosol.exception.BadRequestException;
import br.com.hellosol.hellosol.exception.BusinessException;
import br.com.hellosol.hellosol.exception.InternalServerErrorException;
import br.com.hellosol.hellosol.exception.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResourceHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> notFoundException(NotFoundException n) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseDTO.builder()
                .message(n.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .StatusCode(HttpStatus.NOT_FOUND.value())
                .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> badRequestException(BadRequestException b) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(b.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .StatusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> badRequestException(MethodArgumentNotValidException m) {

        Map<String, String> messages = new HashMap<>();

        m.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            messages.put(field, defaultMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(Arrays.toString(messages.entrySet().toArray()))
                .httpStatus(HttpStatus.BAD_REQUEST)
                .StatusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDTO> badRequestException(DataIntegrityViolationException d) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(d.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .StatusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDTO> badRequestException(BusinessException b) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponseDTO.builder()
                .message(b.getMessage())
                .httpStatus(HttpStatus.CONFLICT)
                .StatusCode(HttpStatus.CONFLICT.value())
                .build());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseDTO> internalServerErrorException(InternalServerErrorException b) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponseDTO.builder()
                .message(b.getMessage())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .StatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build());
    }
}
