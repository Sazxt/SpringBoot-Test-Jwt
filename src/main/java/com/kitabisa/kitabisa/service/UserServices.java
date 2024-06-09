package com.kitabisa.kitabisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kitabisa.kitabisa.model.Users;
import com.kitabisa.kitabisa.repository.UsersdataRepository;

@Service
public class UserServices implements UserDetailsService{
    @Autowired
    private UsersdataRepository usersdatarepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users userscreate(Users users)
    {
        if (usersdatarepository.existsByEmail(users.getEmail()))
        {
            throw new IllegalArgumentException("email already exists");
        }
        if (usersdatarepository.existsByUsername(users.getUsername()))
        {
            throw new IllegalArgumentException("Username already exists");
        }
        Users user = new Users();
        user.setUsername(users.getUsername());
        user.setPassword(passwordEncoder.encode(users.getPassword()));
        user.setEmail(users.getEmail());
        user.setNik(users.getNik());
        user.setAlamat(users.getAlamat());
        user.setTingkat(users.getTingkat());
        return usersdatarepository.save(user);
    }

    public Users findByUsername(String username) {
        return usersdatarepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersdatarepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER") // You can set roles or authorities here
                .build();
    }
}
