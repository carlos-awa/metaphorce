package com.example.challenge_crud.controlador;
import com.managment.security.transversal.response;
import org.apache.coyote.Response;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ControllerAdvice
public class ControlerExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Response<Object> ExceptionHandler(Exception e){
        String idFailure = UUID.randomUUID().toString();

        Response<Object> response = new Response<>();
        response.setMessage(String.format(Message.ErrorInesperado, idFailure));
        response.setIsWarning(false);
        response.setIsSucces(false);

        return response;
    }
}
