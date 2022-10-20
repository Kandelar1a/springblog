package com.digitalersjava.springblog.repositories;

import com.digitalersjava.springblog.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {}
