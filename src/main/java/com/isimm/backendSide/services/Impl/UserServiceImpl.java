package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.dto.CredentialsDto;
import com.isimm.backendSide.dto.UserDto;
import com.isimm.backendSide.entities.Department;
import com.isimm.backendSide.entities.Role;
import com.isimm.backendSide.entities.User;
import com.isimm.backendSide.exceptions.AppException;
import com.isimm.backendSide.mappers.UserMapper;
import com.isimm.backendSide.repositories.UserRepository;
import com.isimm.backendSide.services.DepartmentService;
import com.isimm.backendSide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JWTService jwtService;
    @Override
    public User findById(Long id) {
        Optional<User> opUser = userRepository.findById(id);
        if(opUser.isEmpty()){
            throw new AppException("User is not exists with the given id :"+id, HttpStatus.NOT_FOUND);
        }
        return opUser.get();
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> optionalUser =userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            throw new AppException("Un utilisateur existe déjà avec ce Email : "+userDto.getEmail(), HttpStatus.BAD_REQUEST);
        }
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        UserDto userDto1 =UserMapper.mapToUserDto(savedUser);
        String token = jwtService.generateToken(userDto.getEmail());
        userDto1.setToken(token);
        return userDto1;
    }

    @Override
    public UserDto verify(CredentialsDto credentialsDto) {
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(credentialsDto.getEmail(),new String(credentialsDto.getPassword()))
        );
        // Nettoyer le mot de passe en mémoire après l'authentification
        Arrays.fill(credentialsDto.getPassword(), '\0');
        if(authentication.isAuthenticated()){
            // Génération du token
            String token = jwtService.generateToken(credentialsDto.getEmail());
            User user = userRepository.findByEmail(credentialsDto.getEmail())
                    .orElseThrow(()-> new AppException("Utilisateur non trouvé",HttpStatus.NOT_FOUND));
            UserDto userDto = UserMapper.mapToUserDto(user);
            userDto.setToken(token);
            return userDto;
        }
        throw new AppException("Mot de passe incorrect", HttpStatus.BAD_REQUEST);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new AppException("User with name '" + name + "' not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public UserDto getUserById(Long UserId) {
        User dep = userRepository.findById(UserId)
                .orElseThrow(()->new AppException("User is not exists with the given id :"+UserId, HttpStatus.NOT_FOUND));
        return UserMapper.mapToUserDto(dep);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> Users = userRepository.findAll();
        return Users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long UserId, UserDto updatedUser) {
        /*User user = userRepository.findById(UserId).orElseThrow(
                ()-> new AppException("User is not exists with given id :"+UserId, HttpStatus.NOT_FOUND));
        //lorsque l'utilisateur est mis à jour, il doit être retiré de l'ancien département et ajouté au nouveau
        user.getDepartmentU().getUsers().remove(user);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        Department depNouveau =departmentService.findByName(updatedUser.getDepartmentU());
        user.setDepartmentU(depNouveau);
        user.setActive(updatedUser.getActive());
        depNouveau.getUsers().add(user);
        userRepository.save(user);
        return UserMapper.mapToUserDto(user);*/
        return null;
    }

    @Override
    public void deleteUser(Long UserId) {
        User User = userRepository.findById(UserId).orElseThrow(
                ()-> new AppException("User is not exists with given id :"+UserId, HttpStatus.NOT_FOUND));
        boolean remove = User.getDepartmentU().getUsers().remove(User);
        if(!remove){
            throw new AppException("User is not exists in any department", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(UserId);
    }

    @Override
    public User createUser(String name, String email, String password, Role role, String departmentU,  Boolean isActive) {
        Department department = departmentService.findByName(departmentU);
        User user = new User(name,email,password,role,department,isActive);
        department.getUsers().add(user);
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException("User with email '" + email + "' not found", HttpStatus.NOT_FOUND));
    }

}
