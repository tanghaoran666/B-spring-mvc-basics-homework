package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.entity.UserPo;
import com.thoughtworks.capacity.gtb.mvc.exception.NotMatchException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    Map<String, String> userPasswordMap = new HashMap<>();
    Map<String, UserPo> userMap = new HashMap<>();

    public void register(User user) {
        if (userMap.containsKey(user.getUsername())) {
            throw new NotMatchException("username already exist");
        }
        UserPo userPo = UserPo.builder().email(user.getEmail())
                .password(user.getPassword())
                .username(user.getUsername())
                .id(userMap.size() + 1)
                .build();
        userPasswordMap.put(user.getUsername(), user.getPassword());
        userMap.put(user.getUsername(), userPo);
    }

    public UserPo getUser(String username, String password) {
        if (!userMap.containsKey(username) || !userPasswordMap.get(username).equals(password)) {
            throw new NotMatchException("username or password wrong");
        } else {
            return userMap.get(username);
        }

    }
}
