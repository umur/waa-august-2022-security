package com.javokhir.lab6.mapper;

import com.javokhir.lab6.domain.LocalUser;
import com.javokhir.lab6.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    LocalUser fromDto(UserDto userDto);

    @Mapping(target = "password", ignore = true)
    UserDto toDto(LocalUser user);
}
