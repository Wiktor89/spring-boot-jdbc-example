package com.example.springbootjdbcexample.dao.jdbc;

import com.example.springbootjdbcexample.dao.IDAO;
import com.example.springbootjdbcexample.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.springbootjdbcexample.dao.jdbc.UserDAOImpl.RowMapper.getUserMapper;
import static com.example.springbootjdbcexample.dao.jdbc.UserDAOImpl.RowMapper.getUsersMapper;

public class UserDAOImpl extends JdbcDaoSupport implements IDAO {

    private static final Logger LOGGER = LogManager.getLogger (UserDAOImpl.class);

    @Autowired
    @Qualifier ("dataSource")
    private DataSource dataSource;

    @PostConstruct
    private void init () {
        setDataSource (dataSource);
    }

    @Override
    public void add (User user) {
        String sql = "INSERT INTO test_users (login, password) VALUES (?,?)";
        try (Connection connection = getDataSource ().getConnection ();
             PreparedStatement statement = connection.prepareStatement (sql)) {
            statement.setString (1, user.getLoggin ());
            statement.setString (2, user.getPassword ());
            statement.execute ();
        } catch (Exception e) {
            LOGGER.debug ("Ошибка ", e);
        }
    }

    @Override
    public User getUser (Integer id) {
        User user = null;
        String sql = "SELECT * FROM test_users WHERE id = ?";
        try (Connection connection = getDataSource ().getConnection ();
             PreparedStatement statement = connection.prepareStatement (sql)) {
            statement.setInt (1, id);
            user = getUserMapper (statement.executeQuery ());
        } catch (Exception e) {
            LOGGER.debug ("Ошибка ", e);
        }
        return user;
    }

    @Override
    public User update (Integer id, User userDetails) {
        User user = null;
        String sql = "UPDATE test_users SET login = ?,password = ? WHERE id = ?";
        try (Connection connection = getDataSource ().getConnection ();
             PreparedStatement statement = connection.prepareStatement (sql)) {
            statement.setString (1, userDetails.getLoggin ());
            statement.setString (2, userDetails.getPassword ());
            statement.setInt (3, id);
            statement.executeUpdate ();
            user = getUser (id);
        } catch (Exception e) {
            LOGGER.debug ("Ошибка ", e);
        }
        return user;
    }

    @Override
    public void delete (Integer id) {
        String sql = "DELETE FROM test_users WHERE id = ?";
        try (Connection connection = getDataSource ().getConnection ();
             PreparedStatement statement = connection.prepareStatement (sql)) {
            statement.setInt (1, id);
            statement.executeQuery ();
        } catch (Exception e) {
            LOGGER.debug ("Ошибка ", e);
        }
    }

    @Override
    public List<User> getUsers () {
        List<User> userList = null;
        String sql = "SELECT * FROM test_users";
        try (Connection connection = getDataSource ().getConnection ();
             PreparedStatement statement = connection.prepareStatement (sql)) {
            userList = getUsersMapper (statement.executeQuery ());
        } catch (Exception e) {
            LOGGER.debug ("Ошибка ", e);
        }
        return userList;
    }

    static class RowMapper {

        static User getUserMapper (ResultSet resultSet) {
            User user = null;
            try {
                while (resultSet.next ()) {
                    Integer id = resultSet.getInt ("id");
                    String login = resultSet.getString ("login");
                    String password = resultSet.getString ("password");
                    user = new User (id, login, password);
                }
            } catch (SQLException e) {
                LOGGER.debug ("Ошибка ", e);
            }
            return user;
        }

        static List<User> getUsersMapper (ResultSet resultSet) {
            List<User> userList = new ArrayList<> ();
            try {
                while (resultSet.next ()) {
                    Integer id = resultSet.getInt ("id");
                    String login = resultSet.getString ("login");
                    String password = resultSet.getString ("password");
                    userList.add (new User (id, login, password));
                }
            } catch (SQLException e) {
                LOGGER.debug ("Ошибка ", e);
            }
            return userList;
        }
    }

}
