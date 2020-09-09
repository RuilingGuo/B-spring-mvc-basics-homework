package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.RegisterUserFailedException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserLoginException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {


    private static Integer USER_INC_ID = 1;
    private Map<String ,User> userList;

    public UserService() {
        this.userList = new HashMap<>();
    }

    public void registerUser(User user) {
        if(userList.containsKey(user.getUsername())){
            throw new RegisterUserFailedException("用户名已存在");
        }
        user.setId(USER_INC_ID++);
        userList.put(user.getUsername(),user);
    }

    public User login(String username, String password) {
        Optional<User> optionalUser = Optional.ofNullable(userList.get(username));
        if(!optionalUser.isPresent()){
            throw new UserLoginException("用户名或密码错误");
        }
        User user = optionalUser.get();
        if(!user.getPassword().equals(password)){
            throw new UserLoginException("用户名或密码错误");
        }
        return user;
    }
}
