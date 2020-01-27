package com.FayTax.FayTax.controller;


import com.FayTax.FayTax.api.UserApi;
import com.FayTax.FayTax.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserApi userApi;
    @GetMapping("/")
    public String list(){
        return "users";
    }
    @PostMapping(value = "/addUser", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addUser(User user){
        return userApi.create(user);
    }

}
