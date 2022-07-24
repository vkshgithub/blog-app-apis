package com.mycode.blog.controllers;

import com.mycode.blog.entities.User;
import com.mycode.blog.payloads.UserDto;
import com.mycode.blog.services.UserService;
import com.mycode.blog.services.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //GET
    @GetMapping("/")
    public ResponseEntity<UserDto> getUser(@RequestParam("id") Integer userId){
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //PUT
//    public ResponseEntity<UserDto> updateUser(){
//
//    }
}
