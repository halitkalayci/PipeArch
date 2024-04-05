package com.halitkalayci.pipearch.core.persistence;

import com.halitkalayci.pipearch.core.domain.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseUserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
}
