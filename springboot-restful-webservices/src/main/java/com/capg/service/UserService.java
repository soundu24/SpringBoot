package com.capg.service;

import java.util.List;

import com.capg.dto.UserDto;
import com.capg.entity.User;

public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto getUserById(Long userId);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(UserDto user);
	
	void deleteUser(Long userId);
}
