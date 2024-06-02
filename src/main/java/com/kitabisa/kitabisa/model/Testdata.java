package com.kitabisa.kitabisa.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "testdata")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Testdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "wallet")
    private String wallet;

    @Column(name = "email")
    private String email;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Testdata() {

    }

    public Testdata(String username, String alamat, String wallet, String email) {
        this.username = username;
        this.alamat = alamat;
        this.wallet = wallet;
        this.email = email;
    }

}
