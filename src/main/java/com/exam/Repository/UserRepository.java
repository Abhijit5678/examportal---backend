package com.exam.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(nativeQuery = true,value = "SELECT * FROM t_user where username=:username")
	User findbyUsername(String username);
	@Query(nativeQuery = true,value = "SELECT * FROM t_user where username=:username")
	Optional<User> findByName(String username);
	

}
