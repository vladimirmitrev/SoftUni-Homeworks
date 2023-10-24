package com.softuni.pathfinder.config;

import com.softuni.pathfinder.repository.UserRepository;
import com.softuni.pathfinder.service.impl.PathfinderUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class PathfinderSecurityConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

   @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
   }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {



//                .securityMatcher("/") Spring Boot 3.1.0
        // define which requests are allowed and which not
        http
                .authorizeHttpRequests()
                // everyone can download static resources (css, js, images)
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                // everyone can login and register
                .requestMatchers("/", "/routes/**","/about","/api/**").permitAll()
                .requestMatchers("/users/profile").authenticated()
                .requestMatchers("/users/login", "/users/register").anonymous()
                // all other pages are available for logger in users
                .anyRequest()
                .authenticated()
                .and()
                // configuration of form login
                .formLogin()
                // the custom login form
                .loginPage("/users/login")
                // the name of the username form field
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                // the name of the password form field
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                // where to go in case that the login is successful
                .defaultSuccessUrl("/")
                // where to go in case that the login failed
//                .failureForwardUrl("/users/login-error")
                .and()
                // configure logut
                .logout()
                // which is the logout url
                .logoutUrl("/users/logout")
                .logoutSuccessUrl("/")
                // invalidate the session and delete the cookies
                .invalidateHttpSession(true)
//                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");


        return http.build();
    }

   @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new PathfinderUserDetailsService(userRepository);
   }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/error", "/resources/**");
    }
}
