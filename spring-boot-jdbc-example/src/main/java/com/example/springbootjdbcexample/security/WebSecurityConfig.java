package com.example.springbootjdbcexample.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AccessDeniedHandler handler;

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests ().antMatchers ("/", "/home").permitAll ()
        .anyRequest ().authenticated ().and ().formLogin ().loginPage ("/login").permitAll ()
                .and ().logout ().permitAll ();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService () {
        UserDetails userDetails = User.withUsername ("test").password ("test").roles ("USER").build ();
        return new InMemoryUserDetailsManager ((Collection<UserDetails>) userDetails);
    }
}
