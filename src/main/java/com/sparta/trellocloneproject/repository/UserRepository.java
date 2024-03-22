package com.sparta.trellocloneproject.repository;



import com.sparta.trellocloneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String user);
    Optional<User> findById(Long id);
}


