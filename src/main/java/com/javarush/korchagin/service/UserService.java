package com.javarush.korchagin.service;

import com.javarush.korchagin.dbo.UserRepository;
import com.javarush.korchagin.entity.User;

import java.util.stream.Stream;

public class UserService {
   private final UserRepository userRepository = new UserRepository();

   public User findUserByUsername(String username) {
      Stream<User> userStream = userRepository.find(User.builder().login(username).build());
      return userStream.findFirst().get();
   }
}
