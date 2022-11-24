package com.example.brgain.service;

import com.example.brgain.model.User;
import com.example.brgain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;



  public User authenticationLogin(String username, String password){

    if(Objects.isNull(username) || Objects.isNull(password) ||
    username.equals("") || password.equals("") ){
      throw new IllegalArgumentException("Username or password cannot be null or empty");
    }

    List<User> userList = userRepository.findByEmailAndPassword(username, password);
    if(!CollectionUtils.isEmpty(userList)){
      return userList.get(0);
    }
    throw new IllegalStateException("User name or password incorrect, please try again");
  }

  public User registerUser(User user){
    String email = user.getEmail();
    List<User> byEmail = userRepository.findByEmail(email);
    if(!CollectionUtils.isEmpty(byEmail)){
      throw new IllegalStateException("User with email Id already exists, try to login instead.");
    }
    return userRepository.save(user);
  }

}
