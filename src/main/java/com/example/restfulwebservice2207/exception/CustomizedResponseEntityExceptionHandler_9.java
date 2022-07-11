package com.example.restfulwebservice2207.exception;

import com.example.restfulwebservice2207.user.UserNotFoundException_7;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/*
ResponseEntityExceptionHandler를 상속받는 클래스
사용하는 시스템에서 에러가 발생하게되면,
에러를 핸들링하기 위해 스프링 부트에서 제공되는 클래스
 */


@ControllerAdvice
@RestController
/*
모든 컨트롤러가 실행이 될때 @ControllerAdvice 어노테이션을 가지고
있는 빈이 실행되게 되어있는데
만약 에러가 발생 하면 예외 핸들러 클래스가 실행됨
 */
public class CustomizedResponseEntityExceptionHandler_9 extends ResponseEntityExceptionHandler {
    // 모든 예외처리를 처리해주는 메소드
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        /*
         handleAllException(Exception ex, WebRequest request)
         Exception ex : 에러객체
         WebRequest : 어디서 발생했는지에 대한 정보
         */
        ExceptionResponse_8 exceptionResponse =
                new ExceptionResponse_8(
                        new Date(), ex.getMessage(),
                request.getDescription(false));

        // 서버에서 가장 일반화되어있는 오류 : 500번 / HttpStatus.INTERNAL_SERVER_ERROR
        // ResponseEntity 빈을 생성
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
// 만약 에러가 발생하면 예외 핸들러 클래스가 실행됨.
// 사용자가 존재하지 않았을 때 사용하는 UserNotFound Exception
    @ExceptionHandler(UserNotFoundException_7.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        /*
        handleAllException(Exception ex, WebRequest request)
        Exception ex : 에러객체
        WebRequest : 어디서 발생했는지에 대한 정보
         */

        ExceptionResponse_8 exceptionResponse = new ExceptionResponse_8(new Date(), ex.getMessage(),
                request.getDescription(false));
        //NOT_FOUND
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }


}

