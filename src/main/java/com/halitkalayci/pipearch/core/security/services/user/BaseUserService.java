package com.halitkalayci.pipearch.core.security.services.user;

import com.halitkalayci.pipearch.core.domain.concretes.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface BaseUserService extends UserDetailsService {
  User add(User user);
  User findByEmail(String email);
}
