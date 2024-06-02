package com.kitabisa.kitabisa.service;

import com.kitabisa.kitabisa.dao.request.SignUpRequest;
import com.kitabisa.kitabisa.dao.request.SigninRequest;
import com.kitabisa.kitabisa.dao.response.JwtAuthenticationResponse;

/**
 * AuthtencationService
 */
public interface AuthtencationService {

    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}