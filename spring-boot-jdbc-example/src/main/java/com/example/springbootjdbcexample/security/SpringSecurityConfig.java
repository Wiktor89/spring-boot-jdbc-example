package com.example.springbootjdbcexample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/about").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication ().dataSource (dataSource).usersByUsernameQuery (
                "SELECT login, password FROM test_users WHERE login = a").passwordEncoder (new BCryptPasswordEncoder ());
//        auth.inMemoryAuthentication()
//                .withUser("user").password("q").roles("USER")
//                .and()
//                .withUser("admin").password("q").roles("ADMIN");
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService () {
//        List<UserDetails> list = new ArrayList<> ();
//        list.add (User.withUsername ("test").password ("test").roles ("USER").build ());
//        list.add (User.withUsername ("a").password ("a").roles ("ADMIN").build ());
//        return new InMemoryUserDetailsManager (list);
//    }
}
