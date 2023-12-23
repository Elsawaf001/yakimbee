package com.elsawaf.yakimbee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL ,optional = false, orphanRemoval = true)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;



}