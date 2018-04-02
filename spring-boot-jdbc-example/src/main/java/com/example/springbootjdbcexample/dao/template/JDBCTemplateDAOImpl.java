package com.example.springbootjdbcexample.dao.template;

import com.example.springbootjdbcexample.dao.IDAO;
import com.example.springbootjdbcexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("jdbcTemp")
public class JDBCTemplateDAOImpl extends JdbcDaoSupport implements IDAO {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @PostConstruct
    private void init() {
        setDataSource (dataSource);
    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO test_users (login, password) VALUES (?,?)";
        getJdbcTemplate ().update (sql, user.getLoggin (), user.getPassword ());
    }

    @Override
    public User getUser(Integer id) {
        String sql = "SELECT * FROM test_users WHERE id = ?";
        return getJdbcTemplate ().queryForObject (sql, new Object[]{id}, (resultSet, i) -> {
            User user = new User ();
            user.setLoggin (resultSet.getString ("login"));
            user.setPassword (resultSet.getString ("password"));
            return user;
        });
    }

    @Override
    public User update(Integer id, User userDetails) {
        String sql = "UPDATE test_users SET login = ?,password = ? WHERE id = ?";
        getJdbcTemplate ().update (sql, userDetails.getLoggin (), userDetails.getPassword (), id);
        return getUser (id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM test_users WHERE id = ?";
        getJdbcTemplate ().update (sql, id);
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM test_users";
        List<Map<String, Object>> list = getJdbcTemplate ().queryForList (sql);
        List<User> userList = new ArrayList<> ();
        for (Map<String, Object> row : list) {
            User user = new User ();
            user.setLoggin ((String) row.get ("login"));
            user.setPassword ((String) row.get ("password"));
            userList.add (user);
        }
        return userList;
    }

}
