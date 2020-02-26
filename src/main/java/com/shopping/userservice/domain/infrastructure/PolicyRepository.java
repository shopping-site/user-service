package com.shopping.userservice.domain.infrastructure;

import com.shopping.userservice.domain.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, String> {
}
