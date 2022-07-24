package com.mycode.blog.services;

import com.mycode.blog.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Integer userId);

    UserDto updateUser(UserDto userDto, Integer id);

    List<UserDto> getAllUsers();

    void deleteUser(Integer id);


}
