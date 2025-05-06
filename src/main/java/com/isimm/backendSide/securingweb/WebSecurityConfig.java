package com.isimm.backendSide.securingweb;

import com.isimm.backendSide.services.Impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Go with my configuration not the default one

public class WebSecurityConfig {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    //definir les filtres à appliquer à chaque requête
    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private UserAuthenticationEntryPoint userAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //faire une authentification pour chaque requette
        //désactiver csrf pour avoir le JWT
        http.csrf(AbstractHttpConfigurer::disable)
            .exceptionHandling(exceptionHandling ->
                    exceptionHandling.authenticationEntryPoint(userAuthenticationEntryPoint))
            .addFilterBefore(jwtFilter , UsernamePasswordAuthenticationFilter.class)
            //any request should be authenticated
            .authorizeHttpRequests(request -> request
                    //pour les pages register et login, on peut y acceder sans authentification
                    .requestMatchers(HttpMethod.POST,"/api/users/register","/api/users/login").permitAll()
                    .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults()) //pour rest API avec postman
            //désactiver les sessions
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .logout(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        //DaoAuthenticationProvider est une classe qui implemente l'interface AuthenticationProvider
        //pour la validation des utilisateurs avec le password deja dans la base de données
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
