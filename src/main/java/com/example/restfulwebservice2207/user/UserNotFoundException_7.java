package com.example.restfulwebservice2207.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//
/* UserResource_6 클래스에서 호출
@GetMapping("/users/{id}")
    public User_4 retrieveUser(@PathVariable int id){
        User_4 user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException_7("id-" + id);

            return user;
    }
 */
//예외클래스 생성
//Http Status Code 제어를 위한 Exception handling
//특정한 예외 지정 - @ResponseStatus(HttpStatus.NOT_FOUND)
/*
HTTP Status Code
2xx -> ok
4xx -> client 오류
5xx -> server 오류
데이터가 존재하지 않는 오류기때문에
5xx 오류메시지가 아니라 NotFound 오류메시지 전달해 주기
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException_7 extends RuntimeException {
//   Generate -> Constructor -> UserNotFoundException(String message)
    public UserNotFoundException_7(String message) {
        super(message);
    }
}
