package com.elsawaf.yakimbee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(nullable = false , length = 50)
    @NotEmpty(message = "first name can't be empty")
    private String firstName;
    @NotEmpty(message = "last name can't be empty")
    @Column(nullable = false , length = 50)
    private String lastName;
    @Size(max = 255)
    @Column(nullable = false, unique = true)
    @Email
    @NotEmpty(message = "invalid Email , Please Enter an email address")
    private String email;
    @Column(nullable = false, length = 150)
    private String password;
    private String address;
    @Column(length = 100)
    private String phone;
    @Column(length = 100)
    private String title;
    private String bio;
    private String imageUrl;
    private boolean enabled;
    private boolean isNotLocked;
    private boolean isUsingMfa;

    @CreatedBy
    @Column(name = "created_by",  length = 50, updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate = Instant.now();


}