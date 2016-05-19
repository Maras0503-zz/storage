/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.UserEntity;
/**
 *
 * @author Marek
 */
public class DbQueries {
    public DbConnect conn = new DbConnect();
 
    public UserEntity login(String log, String pas){
        UserEntity userAns = new UserEntity();
        userAns.setLoginSucces(false);
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT user_id, user_fname, user_lname, user_type, user_pass_expiration FROM user_tab WHERE user_login=? and user_pass=?"
            );
            conn.stmt.setString(1, log);
            conn.stmt.setString(2, pas);
            conn.result = conn.stmt.executeQuery();
            conn.result.last();
            userAns.setLoginSucces(true);
            userAns.setId(conn.result.getInt("user_id"));
            userAns.setFname(conn.result.getString("user_fname"));
            userAns.setLname(conn.result.getString("user_lname"));
            userAns.setType(conn.result.getInt("user_type"));
            userAns.setPass_expiration(conn.result.getLong("user_pass_expiration"));
        }
        catch(SQLException e){
        }
        conn.disconnect();
        return userAns;
    }
}
