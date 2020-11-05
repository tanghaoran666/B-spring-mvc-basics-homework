package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.entity.UserPo;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user) {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/login")
    public ResponseEntity<UserPo> login(@RequestParam @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message = "username is illegal") @Size(min = 3, max = 10, message = "username is illegal") String username,
                                        @RequestParam @Size(min = 5, max = 12, message = "password is illegal") String password) throws Exception {
        UserPo userPo = userService.getUser(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(userPo);
    }


}
