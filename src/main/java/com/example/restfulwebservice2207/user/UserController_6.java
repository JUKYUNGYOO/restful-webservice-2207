package com.example.restfulwebservice2207.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Controller class 생성 -> service 를 파라미터로 받아 의존성 주입
@RestController
public class UserController_6 {

    //@Autowired - 빈클래스(UserDaoService_5의 자동주입)
    //생성자(빈클래스)를 통한 의존성 주입
    @Autowired
    private UserDaoService_5 service;

    /* 생성자를 통한 의존성 주입 
    public UserController_6(UserDaoService_5 service){
        this.service = service;
    }*/




    //사용자 리스트 리턴  - GET /users
    @GetMapping("/users")
    public List<User_4> retrieveAllUsers(){
        return service.findAll();
    }


    // 사용자 한명 리턴 - Get /users/{id} -> /users/1
    // Controller로 전달되면 String 형태로 전달 됨. 
    // 자동으로 int형 매핑
    @GetMapping("/users/{id}")
    public User_4 retrieveUser(@PathVariable int id){
        User_4 user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException_7(String.format
                    ("ID[%s] not found",id));

            return user;
    }

//    CREATED - 새로운 사용자를 등록하는 method구현
//    input - details of user
//    output - CREATED & Return the created URI
//    uri created users

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User_4 user){
        User_4 savedUser = service.save(user);
        //save()메소드는 UserDaoService_5 클래스에 정의됨.
        //CREATED
        // /user/{id} savedUser.getId()

        //사용자에게 요청 값 변환
        //fromCurrentRequest() : 현재 요청되어진 request값을 사용한다는 뜻
        //path : 반환 시켜줄 값
        //savedUser.getId() : {id} 가변변수에 새롭게 만들어진 id값 저장
        //toUri() : URI형태로 변환
        //uri component
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        //response entity -> HttpEntity -> satus called back
        return ResponseEntity.created(location).build();
        //there is a something call
        //parsing on to the location
        //how do I created? - url
    }



    //retrieveUser(int id) - Get /users/{id} -> /users/1
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User_4 user = service.deleteById(id);
        if(user==null) {
            throw new UserNotFoundException_7(String.format("ID[%s] not found", id));
        }
    }

}
