package com.shopping.userservice.domain.infrastructure;

import com.shopping.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
