package com.kitabisa.kitabisa.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * JwtService
 */
public interface JwtService {

    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}