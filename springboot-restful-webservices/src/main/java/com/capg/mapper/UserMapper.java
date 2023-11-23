package com.capg.mapper;

import com.capg.dto.UserDto;
import com.capg.entity.User;

public class UserMapper {

	//convert User JPA entity into UserDto
	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
				); 
		return userDto;
	}
	
	//convert UserDto entity into JPA Entity
	public static User mapToUser(UserDto userDto) {
		User user = new User(
				userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail()
				); 
		return user;
	}
}
