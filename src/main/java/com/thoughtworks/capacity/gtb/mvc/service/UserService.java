package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.RegisterUserFailedException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String ,User> userList;

    public UserService() {
        this.userList = new HashMap<>();
    }

    public void registerUser(User user) {
        if(userList.containsKey(user.getUsername())){
            throw new RegisterUserFailedException("用户名已存在");
        }
        userList.put(user.getUsername(),user);
    }
}
