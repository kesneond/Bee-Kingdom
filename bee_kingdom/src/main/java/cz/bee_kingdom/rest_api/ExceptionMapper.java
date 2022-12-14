package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.EntityStateException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionMapper {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityStateException.class)
    public Map<String, String> handleEntityException(EntityStateException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("here", "404 Not Guth");
        System.out.println("here");
        return errors;
    }
}
