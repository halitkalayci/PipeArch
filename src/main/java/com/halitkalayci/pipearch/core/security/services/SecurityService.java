package com.halitkalayci.pipearch.core.security.services;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface SecurityService {
  HttpSecurity configureCustomSecurity(HttpSecurity http) throws Exception;
}
