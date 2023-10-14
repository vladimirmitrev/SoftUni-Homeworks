package com.softuni.mobilele.config;


import com.softuni.mobilele.model.enums.UserRoleEnum;
import com.softuni.mobilele.repository.UserRepository;
import com.softuni.mobilele.service.MobileleUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    // OLD SPRING SECURITY
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {



//                .securityMatcher("/") Spring Boot 3.1.0
        // define which requests are allowed and which not
        http
                .authorizeHttpRequests()
                // everyone can download static resources (css, js, images)
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                // everyone can login and register
                .requestMatchers("/", "/users/login", "/users/register").permitAll()
//                .requestMatchers("/users/profile").authenticated()
//                .requestMatchers("/users/login", "/users/register").anonymous()
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
//                .logoutSuccessUrl("/")
                // invalidate the session and delete the cookies
                .invalidateHttpSession(true)
//                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");


        return http.build();
    }

    // NEW SPRING SECURITY
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//
//
//        http
//                .authorizeHttpRequests(
//                        authorizeHttpRequests ->
//                                authorizeHttpRequests.
//                                        requestMatchers(PathRequest.toStaticResources().atCommonLocations())
//                                        .permitAll().
//                                        requestMatchers("/", "/users/login", "/users/register")
//                                        .permitAll().
////                                        requestMatchers("/").hasRole(UserRoleEnum.USER.name()).
////                                        requestMatchers("/").hasRole(UserRoleEnum.ADMIN.name()).
//                                        anyRequest().authenticated()
//                )
//                .formLogin(
//                        (formLogin) ->
//                                formLogin.
//                                        loginPage("/users/login").
//                                        usernameParameter(
//                                                UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
//                                        passwordParameter(
//                                                UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
//                                        defaultSuccessUrl("/")
////                                .failureForwardUrl("/users/login-error")
//                )
//                .logout((logout) ->
//                        logout.logoutUrl("/users/logout").
//                                logoutSuccessUrl("/").//go to homepage after logout
//                                invalidateHttpSession(true)
//                                .deleteCookies("JSESSIONID")
//                );
//
//
//        return http.build();
//    }
    @Bean public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new MobileleUserDetailsService(userRepository);
    }
    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("https://localhost:8081")); //URLs you want to allow
//        configuration.setAllowedMethods(Arrays.asList("GET","POST")); //methods you want to allow
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;


//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userService);
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
}


