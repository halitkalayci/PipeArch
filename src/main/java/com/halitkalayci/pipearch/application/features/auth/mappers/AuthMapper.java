package com.halitkalayci.pipearch.application.features.auth.mappers;

import com.halitkalayci.pipearch.application.features.auth.commands.register.RegisterCommand;
import com.halitkalayci.pipearch.core.domain.concretes.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {
  AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

  User userFromRegisterCommand(RegisterCommand command);
}
