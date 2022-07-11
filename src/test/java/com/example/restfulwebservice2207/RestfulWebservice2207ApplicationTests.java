package com.example.restfulwebservice2207;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
KEY ABSTRACTION - RESOURCE
A resource has an URI(Uniform Resource Identifier)
/users/Ranga/todos/1
/users/Ranga/todos
/users/Ranga
A resource can have different representations
xml, HTML, JSON
create a user - POST/users
delete a user - DELETE/users/1
get all users - GET/users
get one users - GET/users/1
 */

@SpringBootTest
class RestfulWebservice2207ApplicationTests {

    @Test
    void contextLoads() {
    }

}
