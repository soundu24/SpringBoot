package com.capg.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.UserDto;
import com.capg.entity.User;
import com.capg.exception.EmailAlreadyExistsException;
import com.capg.exception.ResourceNotFoundException;
import com.capg.mapper.AutoUserMapper;
import com.capg.mapper.UserMapper;
import com.capg.repository.UserRepository;
import com.capg.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

//	@Autowired
	private UserRepository userRepository;

//	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		// convert userDto into User JPA ENtity
//		User user = UserMapper.mapToUser(userDto);

		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email Already Exists for User");
		}
//		User user = modelMapper.map(userDto, User.class);
		
		User user = AutoUserMapper.MAPPER.mapToUser(userDto);
		
		User savedUser = userRepository.save(user);

		// Convert User JPA Entity to UserDto

//		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

//		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

//		UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
		
		UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

		return savedUserDto;

	}

	@Override
	public UserDto getUserById(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//		return UserMapper.mapToUserDto(user);
		return modelMapper.map(user, UserDto.class);
//		return AutoUserMapper.MAPPER.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
//		return users.stream().map(UserMapper::mapToUserDto)
//		.collect(Collectors.toList());
		return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
//		return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
//				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User users = userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
		users.setFirstName(user.getFirstName());
		users.setLastName(user.getLastName());
		users.setEmail(user.getEmail());
		User updatedUser = userRepository.save(users);
//		return UserMapper.mapToUserDto(updatedUser);
		return modelMapper.map(updatedUser, UserDto.class);
//		return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		User users = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		userRepository.deleteById(userId);

	}

}
