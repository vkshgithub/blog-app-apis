package com.mycode.blog.controllers;

import com.mycode.blog.entities.User;
import com.mycode.blog.payloads.ApiResponse;
import com.mycode.blog.payloads.UserDto;
import com.mycode.blog.services.UserService;
import com.mycode.blog.services.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

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
    @PutMapping("/updateUser")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @RequestParam("id") Integer userId){
        UserDto updatedUserDto = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/deleteUser")
    public ResponseEntity<ApiResponse> deleteUser(@RequestParam Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Successfully Deleted", true), HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
