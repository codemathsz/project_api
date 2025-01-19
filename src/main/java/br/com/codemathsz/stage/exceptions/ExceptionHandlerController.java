package br.com.codemathsz.stage.exceptions;

import br.com.codemathsz.stage.dtos.ErrorMessageDTO;
import jakarta.validation.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ErrorMessageDTO> handlePSQLException(PSQLException e){
        ErrorMessageDTO dto = ErrorMessageDTO.builder()
                .message(e.getMessage())
                .field(null)
                .build();

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
