package com.elsawaf.yakimbee.repository;

import com.elsawaf.yakimbee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select (count(u) > 0) from User u where upper(u.email) like upper(?1)")
    boolean isUserExistByMail(String email);

    boolean existsByEmailLikeIgnoreCase(String email);





}