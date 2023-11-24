package com.capg.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.capg.dto.UserDto;
import com.capg.entity.User;

@Mapper
public interface AutoUserMapper {

	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
