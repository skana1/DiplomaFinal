//package com.example.LoginApp.controller;
//
//import com.example.LoginApp.Service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/users")
//@RequiredArgsConstructor
//public class UserController {
//    private final UserService userService;
//
//    @GetMapping("/me")
//    public String getUser() {
//        // Get the authentication details from the token.
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        // Here we return the user information based on it's role and logic of the service.
//        return userService.getUserDetails(authentication.getName());
//    }
//}
