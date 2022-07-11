package com.example.restfulwebservice2207.user;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//switch this application to jpa

@Service
public class UserDaoService_5 {
    //User_4 타입의 ArrayList선언
    private static List<User_4> users = new ArrayList<>();

    //    ArrayList란 List인터페이스를 상속받은 클래스로
//    크기가 가변적으로 변하는 선형리스트임.

    private static int usersCount = 3;
//    User_4에 객체를 주입하려면 User_4클래스에 생성자 선언
    static{
        users.add(new User_4(1,"Adam", new Date()));
        users.add(new User_4(2,"Eve", new Date()));
        users.add(new User_4(3,"Jack", new Date()));

    }
    //모든 유저 리스트 반환
    public List<User_4> findAll(){
        return users;
    }
    //유저 회원가입 + 유저 count up
    public User_4 save(User_4 user){
        if(user.getId()==null){
            user.setId(++usersCount);

        }
        users.add(user);
        return user;
    }
    // 한명의 유저 반환
    public User_4 findOne(int id) {
        for (User_4 user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    // 사용자 삭제를 위한 API구현 - DELETE HTTP Method
    public User_4 deleteById(int id){
        Iterator<User_4> iterator = users.iterator();

        while (iterator.hasNext()){
            User_4 user = iterator.next();

            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }



}
