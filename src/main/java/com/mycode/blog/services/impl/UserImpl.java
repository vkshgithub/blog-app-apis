package com.mycode.blog.services.impl;

import com.mycode.blog.entities.User;
import com.mycode.blog.payloads.UserDto;
import com.mycode.blog.repositories.UserRepo;
import com.mycode.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = dtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }

    private User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(user.getId());
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAbout(user.getAbout());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
