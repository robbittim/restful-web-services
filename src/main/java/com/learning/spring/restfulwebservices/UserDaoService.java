package com.learning.spring.restfulwebservices;

import com.learning.spring.restfulwebservices.model.User;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static{
        users.add(new User(1,"Admin1",new Date()));
        users.add(new User(2,"Admin2",new Date()));
        users.add(new User(3,"Admin3",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getUserId()==null){
            user.setUserId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findUser(int id){
        for(User user:users){
            if(user.getUserId()==id){
                return user;
            }
        }

        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getUserId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}