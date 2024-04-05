package com.halitkalayci.pipearch.application.features.auth.commands.register;

import an.awesome.pipelinr.Command;
import com.halitkalayci.pipearch.core.security.dtos.AccessToken;
import com.halitkalayci.pipearch.application.features.auth.mappers.AuthMapper;
import com.halitkalayci.pipearch.core.domain.concretes.User;
import com.halitkalayci.pipearch.core.security.services.user.BaseUserService;
import com.halitkalayci.pipearch.core.utils.jwt.JwtService;
import io.jsonwebtoken.security.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCommand implements Command<AccessToken> {
  @Email
  @NotBlank
  private String email;
  @NotBlank
  private String password;


  @Component
  @RequiredArgsConstructor
  public static class RegisterCommandHandler
          implements Command.Handler<RegisterCommand, AccessToken>
  {
    private final BaseUserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AccessToken handle(RegisterCommand registerCommand) {
      User user = AuthMapper.INSTANCE.userFromRegisterCommand(registerCommand);
      user.setPassword(passwordEncoder.encode(registerCommand.getPassword()));

      user = userService.add(user);

      return jwtService.generateToken(user.getUsername());
    }
  }
}
