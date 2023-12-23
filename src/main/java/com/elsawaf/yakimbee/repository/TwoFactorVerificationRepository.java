package com.elsawaf.yakimbee.repository;

import com.elsawaf.yakimbee.entity.TwoFactorVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwoFactorVerificationRepository extends JpaRepository<TwoFactorVerification, Long> {
}