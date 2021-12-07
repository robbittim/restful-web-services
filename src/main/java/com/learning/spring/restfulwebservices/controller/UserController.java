package com.learning.spring.restfulwebservices.controller;

import com.learning.spring.restfulwebservices.UserDaoService;
import com.learning.spring.restfulwebservices.exception.UserNotFountException;
import com.learning.spring.restfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
  public List<User> retrieveAllUser(){
      return userDaoService.findAll();
  }

  @GetMapping("/users/{id}")
  public User retrieveUser(@PathVariable int id){

        User user =  userDaoService.findUser(id);

        if(user == null){
            throw new UserNotFountException("id-"+ id);
        }

        return user;
  }


  @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);

      URI location =  ServletUriComponentsBuilder
              .fromCurrentRequest()
              .path("/{id}")
              .buildAndExpand(savedUser.getId())
              .toUri();

      return ResponseEntity.created(location).build();
  }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){

        User user =  userDaoService.deleteById(id);

        if(user == null){
            throw new UserNotFountException("id-"+ id);
        }
    }



}
