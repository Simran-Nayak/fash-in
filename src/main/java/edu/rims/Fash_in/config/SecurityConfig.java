package edu.rims.Fash_in.config;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.rims.Fash_in.repository.UserRepository;

@Configuration
public class SecurityConfig {
    @Autowired
    private  UserRepository userRepository;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                request -> request
                        .requestMatchers("/style/**", "/JavaScript/**", "/images/**", "/file/**").permitAll()
                        .requestMatchers("/customer/home", "/customer/plp", "/customer/pdp").permitAll()
                        .requestMatchers("/customer/sign-in", "/customer/sign-up").permitAll()
                        .requestMatchers("/file/**", "/user/**", "/").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated());
        http.formLogin(form -> form.loginPage("/customer/sign-in")
                .defaultSuccessUrl("/customer/home"));
        http.logout(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    UserDetailsService detailsService() {
        return (username) -> {
            var user = userRepository.findByUserEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
            return org.springframework.security.core.userdetails.User.builder()
                    .username(username)
                    .password(user.getUserPassword())
                    .roles(user.getUserRole().toString())
                    .build();
        };
    }

}
