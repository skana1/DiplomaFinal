package com.example.LoginApp.service;
import com.example.LoginApp.authenticate.ChangePasswordRequest;
import com.example.LoginApp.exception.UnauthorizedUserException;
import com.example.LoginApp.exception.UserNotFoundException;
import com.example.LoginApp.models.User;
import com.example.LoginApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        public User getUserDetails(String email) {
            return userRepository.findAllByEmail(email).orElseThrow(() ->
                    new UserNotFoundException("User with email: " + email + " was not found"));

        }


        public User getCurrentUser(String email, String full_name) {
            Optional<User> existingUser = userRepository.findAllByEmail(email);
            if (existingUser.isPresent()) {
                User updatedUser = existingUser.get();
                updatedUser.setFull_name(full_name);
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

        public User updatePassword(ChangePasswordRequest data, String user_email) throws UnauthorizedUserException {
            Optional<User> existingUser = userRepository.findAllByEmail(user_email);
            // We find the user who is trying to update their password by using the email on token.
            if (existingUser.isPresent()) {
                User foundUser = existingUser.get(); // Mer te dhenat e userit nga databaza.

                // We encode the new password. Example: "NewPass123!" => "sdjf8kx89l89yn87y!98dwf".
                String encoded_new_password = passwordEncoder.encode(data.getNew_password());

                // We compare the password that is saved on the database with the current_password that the user sent.
                // If they do not match, we throw an error, because it means that the user does not know the password.
                if(passwordEncoder.matches(data.getCurrent_password(), foundUser.getPassword())){
                    // If the user knows its current_password, we set the new password (its encoded version) on database.
                    foundUser.setPassword(encoded_new_password);

                    return userRepository.save(foundUser);
                } else {
                    throw new UnauthorizedUserException("Wrong current password for user with email: " + user_email);
                }
            } else {
                throw new UserNotFoundException("User by email: " + user_email + " was not found");
            }
        }
}

