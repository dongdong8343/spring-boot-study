package org.example.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// User의 CRUD 담당
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
