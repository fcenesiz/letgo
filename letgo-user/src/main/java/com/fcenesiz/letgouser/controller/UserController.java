package com.fcenesiz.letgouser.controller;

import com.fcenesiz.letgouser.service.UserService;
import com.fcenesiz.user.dto.CreateUserRequest;
import com.fcenesiz.user.dto.UpdateUserRequest;
import com.fcenesiz.user.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest)); // 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest userRequest){
        return ResponseEntity.ok(userService.updateUser(id, userRequest));
    }

    /*
    @PatchMapping("/{id}")
    public ResponseEntity<Void> deactiveUserById(@PathVariable("id") Long id){
        userService.deactiveUserById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
     */

}
