package com.vc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vc.entity.Role;
import com.vc.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);

	Optional<Role> findByName(RoleName roleName);
}
