package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entity.User;
import util.JdbcUtil;

public class UserDao {
    private String query;
    

    public void save(User user) {
        query = "INSERT INTO user(user_name, user_email, user_password) VALUES (?, ?, ?)";
         ;
        try (Connection con = JdbcUtil.auto_connect();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPass());

            int count = pstmt.executeUpdate();
            if (count > 0) {
                System.out.println(count + " Row Inserted!!");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

      
    }

    public Collection<User> findAll() {
        List<User> users = new ArrayList<>();
        query = "SELECT * FROM user";

        try (Connection con = JdbcUtil.auto_connect();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_email"),
                        rs.getString("user_password")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
