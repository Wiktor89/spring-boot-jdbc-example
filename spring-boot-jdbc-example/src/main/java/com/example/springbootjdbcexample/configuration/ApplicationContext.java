package com.example.springbootjdbcexample.configuration;

import com.example.springbootjdbcexample.dao.jdbc.UserDAOImpl;
import com.example.springbootjdbcexample.dao.template.JDBCTemplateDAOImpl;
import com.example.springbootjdbcexample.service.UserCrudServiceImpl;
import com.example.springbootjdbcexample.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ApplicationContext {

    @Bean (name = "data")
    public UserCrudServiceImpl userCrudService () {
        return new UserCrudServiceImpl ();
    }

    @Bean (name = "service")
    public UserServiceImpl userService () {
        return new UserServiceImpl ();
    }

    @Bean (name = "jdbc")
    public UserDAOImpl userDAO () {
        return new UserDAOImpl ();
    }

    @Bean (name = "template")
    public JDBCTemplateDAOImpl jdbcTemplateDAO () {
        return new JDBCTemplateDAOImpl ();
    }
}
