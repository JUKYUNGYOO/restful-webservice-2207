package com.example.restfulwebservice2207.helloworld;
//3
public class HelloWorldBean_3 {

    private String message;
    public HelloWorldBean_3(String message){
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format(
                "HelloWorldBean [message=%s]",
                message

        );
    }
}
