
package com.aqamh4.beadando.keret.security;

import com.aqamh4.beadando.keret.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;


@Configuration
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        List<UserDetails> users = userService.findAll().stream()
                .map(user -> {
                    String role = user.getRole() != null ? user.getRole().name() : "USER";
                    return User.builder()
                            .username(user.getUsername())
                            .password("{noop}" + user.getPassword())
                            .roles(role)
                            .build();
                })
                .collect(Collectors.toList());

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/order","/order/item","/","/register","/user/save","/login","/authenticate","/logout").permitAll()
                        .requestMatchers("/users").hasRole("MODERATOR")
                        .requestMatchers("/admin","/add/szakacs","/szakacs/save","/add/food","/food/save").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticate")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll()
                )
                .exceptionHandling(configurer -> configurer
                        .accessDeniedPage("/access-denied")
                );

        return http.build();
    }
}