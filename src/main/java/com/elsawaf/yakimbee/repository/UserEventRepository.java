package com.elsawaf.yakimbee.repository;

import com.elsawaf.yakimbee.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
}