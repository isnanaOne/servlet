package com.playdata.todos.dao;

import com.playdata.todos.config.JdbcConnection;
import com.playdata.todos.dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public void insert(User user) { // user를 받아서 처리할거다
        Connection conn = new JdbcConnection().getJdbc();
            String sql = "insert into users(username, password, name)" +
                    "values(?,?,?)";   
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getPassword());
                pst.setString(3, user.getName());
                pst.executeUpdate(); // 실행시키는 것
            } catch (SQLException e) {
                throw new RuntimeException(e);
                        
            }
        }
    }

