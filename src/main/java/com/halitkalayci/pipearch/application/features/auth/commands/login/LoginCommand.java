package com.halitkalayci.pipearch.application.features.auth.commands.login;

import an.awesome.pipelinr.Command;
import com.halitkalayci.pipearch.core.security.dtos.AccessToken;
import com.halitkalayci.pipearch.core.security.services.user.BaseUserService;
import com.halitkalayci.pipearch.core.utils.jwt.JwtService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"password"})
public class LoginCommand implements Command<AccessToken> {
  @Email
  @NotBlank
  private String email;
  @NotBlank
  private String password;

  @Component
  @RequiredArgsConstructor
  public static class LoginCommandHandler
          implements Command.Handler<LoginCommand, AccessToken>
  {
    private final AuthenticationManager authenticationManager;
    private final BaseUserService userService;
    private final JwtService jwtService;


    @Override
    public AccessToken handle(LoginCommand loginCommand) {
      Authentication authentication = authenticationManager
              .authenticate(new UsernamePasswordAuthenticationToken(loginCommand.getEmail(), loginCommand.getPassword()));
      //TODO:Refactor
      if(!authentication.isAuthenticated())
        throw new RuntimeException("AuthMessages.LOGIN_FAILED");

      return jwtService.generateToken(loginCommand.getEmail());
    }
  }
}
