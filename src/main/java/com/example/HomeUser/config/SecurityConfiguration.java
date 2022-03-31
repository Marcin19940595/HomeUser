package com.example.HomeUser.config;


import com.example.HomeUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("User")
                .password("User1")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/users").permitAll()
                .anyRequest().hasRole("USER")
                .and()
                .formLogin().permitAll();
    }

}
