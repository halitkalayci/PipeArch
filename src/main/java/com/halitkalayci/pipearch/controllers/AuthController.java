package com.halitkalayci.pipearch.controllers;

import an.awesome.pipelinr.Pipeline;
import com.halitkalayci.pipearch.application.features.auth.commands.login.LoginCommand;
import com.halitkalayci.pipearch.application.features.auth.commands.register.RegisterCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final Pipeline pipeline;

  @PostMapping("register")
  public ResponseEntity<?> register(@RequestBody RegisterCommand command)
  {
    return ResponseEntity.ok(command.execute(pipeline));
  }

  @PostMapping("login")
  public ResponseEntity<?> login(@RequestBody LoginCommand command)
  {
    return ResponseEntity.ok(command.execute(pipeline));
  }
}
