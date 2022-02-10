package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    Connection connection;


    public UserDatabase(Connection connection) {
        this.connection = connection;

    }

    public boolean saveUser(User user){
        boolean set = false;

        try {
        String query = "insert into users(name, email, password) values (?, ?, ?)";
        PreparedStatement pt = this.connection.prepareStatement(query);
        pt.setString(1, user.getName());
        pt.setString(2, user.getEmail());
        pt.setString(3, user.getPassword());

        pt.executeUpdate();
        set = true;
    } catch (Exception e) {
        e.printStackTrace();
    }
        return set;
    }

    public User logUser(String email, String password){
        User user = null;

        try {
            String query = "select * from user where email=? and password=?";
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2, password);

            ResultSet rs  = ps.executeQuery();

            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


}

