package com.fcenesiz.letgouser.service;

import com.fcenesiz.letgouser.dto.UserDtoConverter;
import com.fcenesiz.letgouser.exception.UserNotFoundException;
import com.fcenesiz.letgouser.repository.UserRepository;
import com.fcenesiz.user.dto.CreateUserRequest;
import com.fcenesiz.user.dto.UpdateUserRequest;
import com.fcenesiz.user.dto.UserDto;
import com.fcenesiz.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(
                userDtoConverter::convert
        ).collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest userRequest) {
        User user = new User(
                userRequest.getMail(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getMiddleName()
        );
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(Long id, UpdateUserRequest userRequest){
        User user = findUserById(id);
        User updatedUser = new User(
                user.getId(),
                user.getMail(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getMiddleName()
        );
        return userDtoConverter.convert(userRepository.save(updatedUser));
    }

    private User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User couldn't be found by following id: " + id));
    }
    
}
