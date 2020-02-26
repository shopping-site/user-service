package com.shopping.userservice.domain.infrastructure;

import com.shopping.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmailOrMobile(String email, String mobile);
}
