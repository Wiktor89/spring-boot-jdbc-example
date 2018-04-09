package com.example.springbootjdbcexample.dao.template;

import com.example.springbootjdbcexample.dao.IDAO;
import com.example.springbootjdbcexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JDBCTemplateDAOImpl implements IDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add (User user) {
        String sql = "INSERT INTO test_users (login, password) VALUES (?,?)";
        jdbcTemplate.update (sql, user.getLoggin (), user.getPassword ());
    }

    @Override
    public User getUser (Integer id) {
        String sql = "SELECT * FROM test_users WHERE id = ?";
        return jdbcTemplate.queryForObject (sql, new Object[]{id}, (resultSet, i) -> {
            User user = new User ();
            user.setLoggin (resultSet.getString ("login"));
            user.setPassword (resultSet.getString ("password"));
            return user;
        });
    }

    @Override
    public User update (Integer id, User userDetails) {
        String sql = "UPDATE test_users SET login = ?,password = ? WHERE id = ?";
        jdbcTemplate.update (sql, userDetails.getLoggin (), userDetails.getPassword (), id);
        return getUser (id);
    }

    @Override
    public void delete (Integer id) {
        String sql = "DELETE FROM test_users WHERE id = ?";
        jdbcTemplate.update (sql, id);
    }

    @Override
    public List<User> getUsers () {
        String sql = "SELECT * FROM test_users";
        List<Map<String, Object>> list = jdbcTemplate.queryForList (sql);
        List<User> userList = new ArrayList<> ();
        for (Map<String, Object> row : list) {
            User user = new User ();
            user.setId ((Integer) row.get ("id"));
            user.setLoggin ((String) row.get ("login"));
            user.setPassword ((String) row.get ("password"));
            user.setCreateDate ((Date) row.get ("createdate"));
            userList.add (user);
        }
        return userList;
    }

}
