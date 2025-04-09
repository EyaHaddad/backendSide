package com.isimm.backendSide.services;

import com.isimm.backendSide.dto.CredentialsDto;
import com.isimm.backendSide.dto.UserDto;
import com.isimm.backendSide.entities.User;
import com.isimm.backendSide.entities.Role;

import java.util.List;

public interface UserService {
    User findById(Long id);
    UserDto createUser(UserDto userDto);
    UserDto verify(CredentialsDto userDto);
    User findByName (String name);
    UserDto getUserById (Long UserId);
    List<UserDto> getAllUser();
    UserDto updateUser(Long UserId, UserDto updatedUser);
    void deleteUser (Long UserId);
    User createUser(String name, String email, String password, Role role, String departmentU, Boolean isActive);
    User findByEmail(String email);
}
