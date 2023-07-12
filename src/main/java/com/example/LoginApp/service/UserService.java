package com.example.LoginApp.service;
import com.example.LoginApp.exception.UserNotFoundException;
import com.example.LoginApp.models.User;
import com.example.LoginApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

        private final UserRepository userRepository;

        public User getUserDetails(String email) {
            return userRepository.findAllByEmail(email).orElseThrow(() ->
                    new UserNotFoundException("User with email: " + email + " was not found"));

        }


    public User getCurrentUser(String email) {
        Optional<User> existingUser = userRepository.findAllByEmail(email);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setEmail(email);
            return userRepository.save(updatedUser);
        } else {
            throw new UserNotFoundException("User by email: " + email + " was not found");
        }
    }

    public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        public User findUserById(Integer id) {
            return userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("User by Id: " + id + " was not found"));
        }

        public User createUser(User user) {
            return userRepository.save(user);
        }

        public User updatedUser(User user) {
            Optional<User> existingUser = userRepository.findById(user.getId());
            if (existingUser.isPresent()) {
                User updatedUser = existingUser.get();
                updatedUser.setEmail(user.getEmail());
                updatedUser.setFull_name(user.getFull_name());
                updatedUser.setPassword(user.getPassword());
                updatedUser.setRole(user.getRole());
                updatedUser.setCompany(user.getCompany());

                return userRepository.save(updatedUser);
            } else {
                throw new UserNotFoundException("User by Id " + user.getId() + " was not found");
            }
        }

        @Transactional
        public void deleteUser(Integer id) {
            userRepository.deleteUserById(id);
        }
    }

