package com.feuji.weekendtripssecurity.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

	public UserDto convertEntityToDto(User user) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(user, UserDto.class);
	}

	public User convertDtoToEntity(UserDto userDto) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(userDto, User.class);
	}
}
