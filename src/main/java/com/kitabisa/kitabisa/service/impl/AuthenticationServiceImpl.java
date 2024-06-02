package com.kitabisa.kitabisa.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kitabisa.kitabisa.dao.request.SignUpRequest;
import com.kitabisa.kitabisa.dao.request.SigninRequest;
import com.kitabisa.kitabisa.dao.response.JwtAuthenticationResponse;
import com.kitabisa.kitabisa.model.Users;
import com.kitabisa.kitabisa.repository.UsersdataRepository;
import com.kitabisa.kitabisa.service.AuthtencationService;
import com.kitabisa.kitabisa.service.JwtService;
// import com.truongbn.security.dao.request.SignUpRequest;
// import com.truongbn.security.dao.request.SigninRequest;
// import com.truongbn.security.dao.response.JwtAuthenticationResponse;
// import com.truongbn.security.entities.Role;
// import com.truongbn.security.entities.User;
// import com.truongbn.security.repository.UserRepository;
// import com.truongbn.security.service.AuthenticationService;
// import com.truongbn.security.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthtencationService {
    private final UsersdataRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = Users.builder().username(request.getUsername())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
