package com.elsawaf.yakimbee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "reset_password_verification")
public class ResetPasswordVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String url ;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();


    @Column(name = "expiration_date")
    private Instant expirationDate;


}