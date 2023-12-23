package com.elsawaf.yakimbee.service;

import com.elsawaf.yakimbee.domain.UserDTO;
import com.elsawaf.yakimbee.domain.UserDTOMapper;
import com.elsawaf.yakimbee.entity.AccountVerification;
import com.elsawaf.yakimbee.entity.Role;
import com.elsawaf.yakimbee.entity.User;
import com.elsawaf.yakimbee.entity.UserRole;
import com.elsawaf.yakimbee.enumerations.VerificationType;
import com.elsawaf.yakimbee.exception.EmailExistException;
import com.elsawaf.yakimbee.repository.AccountVerificationRepository;
import com.elsawaf.yakimbee.repository.RoleRepository;
import com.elsawaf.yakimbee.repository.UserRepository;
import com.elsawaf.yakimbee.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AccountVerificationRepository accountVerificationRepository;

    @Override
    @SneakyThrows
    public UserDTO createUser(User user) {
        log.info("checking if email exists");
        if (userRepository.isUserExistByMail(user.getEmail())){
            throw new EmailExistException("Email Already Exist , Try To log in");
        }
        log.info("saving the new user");

        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setImageUrl("https://images.unsplash.com/" +
                "photo-1551373884-8a0750074df7?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0." +
                "3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        newUser.setEnabled(true);
        newUser.setNotLocked(true);
        newUser.setUsingMfa(false);
        newUser.setCreatedBy("system");
        userRepository.save(newUser);
        log.info("new user {} , {} using email {} is Saved",
                newUser.getFirstName(), newUser.getLastName(),newUser.getEmail());
        log.info("password is :- {}",user.getPassword());

        log.info("adding a role to user");
        UserRole newUserRole = new UserRole();
        newUserRole.setUser(newUser);
        newUserRole.setRole(getNewUserRole(newUser));
        userRoleRepository.save(newUserRole);

        log.info("saving url in verification table");
        String verificationUrl=getVerificationURL(UUID.randomUUID().toString() , VerificationType.ACCOUNT.getType());
        AccountVerification accountVerification = new AccountVerification();
        accountVerification.setUser(newUser);
        accountVerification.setUrl(verificationUrl);
        accountVerificationRepository.save(accountVerification);


//        log.info("sending email with verification url");
//        to be implemented

        log.info("returning the new user");
        return UserDTOMapper.fromUser(newUser);

    }

    private Role getNewUserRole(User newUser){
        Role role = new Role();
        role.setName("role_user");
        role.setPermission("user:read");
        role.setCreatedBy("system");
        if (roleRepository
                .existsByNameLikeIgnoreCaseAndPermissionLikeIgnoreCase(role.getName(), role.getPermission())){
            return roleRepository.findByNameLikeIgnoreCaseAndPermissionLikeIgnoreCase(role.getName(),role.getPermission());
        }
        roleRepository.save(role);
        return role;

    }


    private String getVerificationURL(String key , String verificationType){
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/user/verify/"+verificationType + "/"+ key)
                .toUriString();
    }



}
