package com.vc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vc.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmailIgnoreCase(String email);
	Boolean existsByEmail(String email);
	List<User> findByIdIn(List<Long> userIds);
	
}
