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
        userList.put(user.getUsername(),user);
    }
}
