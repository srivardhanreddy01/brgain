package com.example.brgain.controller;

import com.example.brgain.model.User;
import com.example.brgain.model.core.ApiResponse;
import com.example.brgain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "test")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @RequestMapping(path="/add" , method = RequestMethod.POST)
  public ApiResponse<?>  addNewUser (@RequestParam String name,
                                     @RequestParam String email, @RequestParam String password) {

    User user = User.builder()
            .userName(name)
            .email(email)
            .password(password)
            .userId(2)
            .build();
    userRepository.save(user);
    return new ApiResponse<>(userRepository.findAll());
  }

  @RequestMapping(path="/all" , method = RequestMethod.GET)
  public ApiResponse<?> getAllUsers() {
//    return userRepository.getUsers();
    List<User> userList = userRepository.findAll();
    return new ApiResponse<>(userList);
  }


  @RequestMapping(path="/allTest" , method = RequestMethod.GET)
  public List<User> getAllUser() {
//    return userRepository.getUsers();
    List<User> userList = userRepository.findAll();
    return userList;

//    return "Test";
  }
}
