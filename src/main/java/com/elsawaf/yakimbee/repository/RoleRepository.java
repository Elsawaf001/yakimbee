package com.elsawaf.yakimbee.repository;

import com.elsawaf.yakimbee.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByNameLikeIgnoreCaseAndPermissionLikeIgnoreCase(String name, String permission);

    Role findByNameLikeIgnoreCaseAndPermissionLikeIgnoreCase(String name, String permission);


}