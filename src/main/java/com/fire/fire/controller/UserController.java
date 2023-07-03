package com.fire.fire.controller;


import com.fire.fire.Model.User;
import com.fire.fire.Service.UserService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity <List<User>> getAllUsers(){
        List<User> users = userService.findAllStudent();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getZawodnik(@PathVariable("id")String id){
        User user = userService.findUserByID(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity <User> addZawodnik(@RequestBody User user){
        User newuser = userService.addUser(user);
        return new ResponseEntity<>(newuser ,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateZawodnik(@RequestBody User user){
        User newuser = userService.updateUser(user);
        return new ResponseEntity<>(newuser,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteZawodnik(@PathVariable("id")String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
