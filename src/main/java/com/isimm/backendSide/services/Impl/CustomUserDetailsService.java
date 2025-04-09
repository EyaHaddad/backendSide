package com.isimm.backendSide.services.Impl;

import com.isimm.backendSide.entities.User;
import com.isimm.backendSide.entities.UserPrincipal;
import com.isimm.backendSide.repositories.UserRepository;
import com.isimm.backendSide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    @Lazy
    private UserService userService;

    @Override
    /*username est l'email*/
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
