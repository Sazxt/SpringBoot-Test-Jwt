package com.kitabisa.kitabisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.kitabisa.kitabisa.model.Users;

@Repository
public interface UsersdataRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);
}
