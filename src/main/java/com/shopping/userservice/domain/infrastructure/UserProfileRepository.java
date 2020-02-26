package com.shopping.userservice.domain.infrastructure;

import com.shopping.userservice.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
}
