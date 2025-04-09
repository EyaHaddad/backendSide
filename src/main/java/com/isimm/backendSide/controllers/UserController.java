package com.isimm.backendSide.controllers;

import com.isimm.backendSide.dto.CredentialsDto;
import com.isimm.backendSide.dto.SignUpDto;
import com.isimm.backendSide.dto.UserDto;
import com.isimm.backendSide.dto.UserDto;
import com.isimm.backendSide.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    //definir un password encoder avec round 12
    private BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
    //Build Add User REST API
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        try{
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            UserDto savedUser = userService.createUser(userDto);
            return ResponseEntity.created(URI.create("/api/users/"+savedUser.getUserId()))
                    .body(savedUser);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody CredentialsDto credentialsDto, HttpServletResponse response){
        UserDto userDto = userService.verify(credentialsDto);
        if (userDto == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        if (credentialsDto.getRememberMe()) {
            Cookie cookie = new Cookie("authToken", userDto.getToken());
            cookie.setMaxAge(60 * 60 * 24 * 30); // 30 jours
            cookie.setHttpOnly(true); // Sécurisez le cookie
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return ResponseEntity.ok(userDto);
        //return ResponseEntity.ok(userService.verify(credentialsDto));
    }

    //Build Get User REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto UserDto = userService.getUserById(id);
        return ResponseEntity.ok(UserDto);
    }
    //Build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> Users = userService.getAllUser();
        return ResponseEntity.ok(Users);
    }
    //Build Update User REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,
                                                          @RequestBody UserDto updatedUser){
        UserDto UserDto = userService.updateUser(id,updatedUser);
        return ResponseEntity.ok(UserDto);
    }
    //Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!");
    }
}
