package com.example.restfulwebservice2207.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
Implementing Generic Exception Handling for all Resources
예외처리를 하기 위해 사용되는 자바 객체
모든 Controller에서 사용 할 수 있는 일반화 된 예외 클래스
AOP 기능 사용
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse_8
{
    private Date timestamp; //예외가 발생한 시간 정보
    private String message; //예외가 발생한 메시지
    private String details; //예외 상세 정보

}

    /*
    public ExceptionResponse_8(Date timestamp,
                               String message,
                               String details)
    {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    */


