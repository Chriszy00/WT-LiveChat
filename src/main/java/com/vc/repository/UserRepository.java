package com.vc.repository;

import java.util.List;
import java.util.Optional;

import com.vc.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vc.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmailIgnoreCase(String email);
	Boolean existsByEmail(String email);
	List<User> findByIdIn(List<Long> userIds);

	@Query("SELECT u FROM User u WHERE u.id != :userId")
	List<User> fetchAllUsersExceptLogged(Long userId);

}
