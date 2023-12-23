package com.elsawaf.yakimbee.service;

import com.elsawaf.yakimbee.domain.UserDTO;
import com.elsawaf.yakimbee.entity.User;

public interface UserService {
    UserDTO createUser(User user);
}
