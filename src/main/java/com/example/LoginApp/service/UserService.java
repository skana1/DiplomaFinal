package com.example.LoginApp.Service;
import com.example.LoginApp.exception.CompanyNotFoundException;
import com.example.LoginApp.exception.UserNotFoundException;
import com.example.LoginApp.models.User;
import com.example.LoginApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserDetails(String email) {
        return userRepository.findAllByEmail(email).orElseThrow(() ->
                new UserNotFoundException("User with email: " + email + " was not found"));

    }
}
