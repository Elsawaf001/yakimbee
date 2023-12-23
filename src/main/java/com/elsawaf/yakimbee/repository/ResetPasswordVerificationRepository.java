package com.elsawaf.yakimbee.repository;

import com.elsawaf.yakimbee.entity.ResetPasswordVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPasswordVerificationRepository extends JpaRepository<ResetPasswordVerification, Long> {
}