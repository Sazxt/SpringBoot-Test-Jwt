package com.kitabisa.kitabisa.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * UserServiceJwt
 */
public interface UserServiceJwt {

    UserDetailsService userDetailsService();
}