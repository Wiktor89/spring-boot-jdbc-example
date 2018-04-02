package com.example.springbootjdbcexample.dao.template;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;

@RunWith(SpringRunner.class)
@JdbcTest
public class JDBCTemplateDAOImplTest {

    @Autowired
    protected JdbcTemplate template;

    @Test
    @AutoConfigureTestDatabase
    public void add() throws Exception {
        String sql = "INSERT INTO test_users(id,login, password) VALUES (1,'test','test')";
        template.update (sql);
        template.queryForObject ("SELECT * FROM test_users WHERE id = ?", new Object[]{1}, (ResultSet resultSet, int i) -> {
            Assert.assertEquals (resultSet.getString ("login"),"test");
            Assert.assertEquals (resultSet.getString ("password"),"test");
            return null;
        });
    }

    @Test
    public void getUser() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void getUsers() throws Exception {
    }

}