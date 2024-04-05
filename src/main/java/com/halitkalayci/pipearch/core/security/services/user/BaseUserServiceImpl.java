package com.halitkalayci.pipearch.core.security.services.user;

import com.halitkalayci.pipearch.core.domain.concretes.User;
import com.halitkalayci.pipearch.core.persistence.BaseUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseUserServiceImpl implements BaseUserService {
  private final BaseUserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
            .findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException(""));
  }

  @Override
  public User add(User user) {
    return userRepository.save(user);
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email).orElse(null);
  }
}
