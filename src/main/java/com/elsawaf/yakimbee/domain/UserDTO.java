package com.elsawaf.yakimbee.domain;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    @Column(length = 100)
    private String phone;
    private String title;
    private String bio;
    private String imageUrl;
    private boolean enabled;
    private boolean isNotLocked;
    private boolean isUsingMfa;

}
