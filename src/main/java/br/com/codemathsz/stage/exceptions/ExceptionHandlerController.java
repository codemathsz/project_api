package br.com.codemathsz.stage.exceptions;

import br.com.codemathsz.stage.dtos.ErrorMessageDTO;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


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
