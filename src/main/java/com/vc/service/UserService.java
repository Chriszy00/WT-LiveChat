package com.vc.service;

import com.vc.entity.User;
import com.vc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> fetchAllUsersExceptLogged(Long userId){
        return userRepository.fetchAllUsersExceptLogged(userId);
    }

    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }
}
