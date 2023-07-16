package com.example.LoginApp.service;

import com.example.LoginApp.authenticate.AuthenticationRequest;
import com.example.LoginApp.authenticate.AuthenticationResponse;
import com.example.LoginApp.authenticate.RegisterRequest;
import com.example.LoginApp.models.Company;
import com.example.LoginApp.models.User;
import com.example.LoginApp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.LoginApp.repository.UserRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        // Si fillim krijove kompanin.
        var company = Company.builder()
                .name(request.getName())
                .description(request.getDescription())
                .slug(request.getSlug())
                .build();

        companyRepository.save(company);

        var user = User.builder()
                .full_name(request.getFull_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .company(company)
                .build();
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findAllByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
