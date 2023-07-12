package com.example.LoginApp.controller;

import com.example.LoginApp.exception.UnauthorizedUserException;
import com.example.LoginApp.models.User;
import com.example.LoginApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> getUser() {
        // Get the authentication details from the token.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Here we return the user information based on it's role and logic of the service.
        User loggedUser = userService.getUserDetails(authentication.getName());
        return new ResponseEntity<User>(loggedUser, HttpStatus.OK);
    }


    @PutMapping("/update/current")
    public ResponseEntity<User> updateCurrentUser(@RequestBody User updatedUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = userService.getCurrentUser(authentication.getName());
        currentUser.setEmail(updatedUser.getEmail());

       User updateUser = userService.createUser(currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updatedUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
