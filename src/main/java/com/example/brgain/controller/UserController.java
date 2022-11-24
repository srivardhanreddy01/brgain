package com.example.brgain.controller;

import com.example.brgain.model.User;
import com.example.brgain.model.core.ApiResponse;
import com.example.brgain.repository.UserRepository;
import com.example.brgain.service.UserService;

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
@RequestMapping(path = "user")
public class UserController {
  @Autowired
  private UserRepository userRepository;


  @Autowired
  private UserService userService;

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

    @RequestMapping(path="/login" , method = RequestMethod.POST)
  public ApiResponse loginUser(@RequestParam String email,
                               @RequestParam String password) {

    return new ApiResponse(userService.authenticationLogin(email, password));
  }

    @RequestMapping(path="/register" , method = RequestMethod.POST)
  public ApiResponse loginUser(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String email
                        ) {
    User user  = User.builder()
            .userName(username)
            .password(password)
            .email(email)
            .build();

    return  new ApiResponse(userService.registerUser(user));

  }



}
