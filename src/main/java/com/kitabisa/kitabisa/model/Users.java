package com.kitabisa.kitabisa.model;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users implements UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "nik")
    private String nik;

    @Column(name = "tingkat")
    private String tingkat;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // public Users()
    // {

    // }

    // public Users(String username, String email, String password, String alamat, String nik, String tingkat){
    //     this.username = username;
    //     this.email = email;
    //     this.password = password;
    //     this.alamat = alamat;
    //     this.nik = nik;
    //     this.tingkat = tingkat;
    // }

    public Collection<? extends GrantedAuthority> getAuthorities() {
    // Logika untuk menentukan otoritas pengguna berdasarkan tingkat atau peran
    if (tingkat != null) {
        return List.of(new SimpleGrantedAuthority("ROLE_" + tingkat.toUpperCase()));
    } else {
        return List.of(new SimpleGrantedAuthority("ROLE_USER")); // Default role jika tingkat tidak ditentukan
    }
    }

    @Override
    public String getUsername() {
        // email in our case
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
