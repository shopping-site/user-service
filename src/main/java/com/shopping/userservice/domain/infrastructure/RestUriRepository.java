package com.shopping.userservice.domain.infrastructure;

import com.shopping.userservice.domain.RestUri;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestUriRepository extends JpaRepository<RestUri, String> {
}
