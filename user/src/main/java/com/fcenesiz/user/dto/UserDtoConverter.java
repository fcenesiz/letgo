package com.fcenesiz.user.dto;

import com.fcenesiz.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User from){
        return new UserDto(
                from.getMail(),
                from.getFirstName(),
                from.getLastName()
        );
    }
}
