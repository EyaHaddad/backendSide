package com.isimm.backendSide.mappers;

import com.isimm.backendSide.dto.SignUpDto;
import com.isimm.backendSide.dto.UserDto;
import com.isimm.backendSide.entities.Department;
import com.isimm.backendSide.entities.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }

    public static User signUpToUser(SignUpDto userDto) {
        return new User(
                userDto.getName(),
                userDto.getEmail(),
                new String(userDto.getPassword())
        );
    }
}
