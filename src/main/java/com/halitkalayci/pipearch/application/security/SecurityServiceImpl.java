package com.halitkalayci.pipearch.application.security;

import com.halitkalayci.pipearch.core.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
  @Override
  public HttpSecurity configureCustomSecurity(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(request -> request.anyRequest().permitAll());
  }
}
