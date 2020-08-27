package com.example.demo.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.UserDto;
import com.example.demo.data.UserEntity;
import com.example.demo.data.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	UsersRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UsersServiceImpl(UsersRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository =userRepository;
		this.bCryptPasswordEncoder= bCryptPasswordEncoder;
	}
	
	@Override
	public UserDto createUser(UserDto userDetails) {
		
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity=modelMapper.map(userDetails, UserEntity.class);
		
		userRepository.save(userEntity);
		
		UserDto returnValue= modelMapper.map(userEntity, UserDto.class);
		
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userRepository.findByEmail(username);
		
		if(userEntity==null) throw new UsernameNotFoundException(username);
		
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity==null) throw new UsernameNotFoundException(email);
		
		return new ModelMapper().map(userEntity, UserDto.class);
	}

}