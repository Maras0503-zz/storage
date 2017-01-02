/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.UserEntity;
import entities.userType;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Marek
 */
public class DbQueriesLogin {
    public DbConnect conn = new DbConnect();
    public UserEntity userAns = new UserEntity();
    
    //LOGOUT
    public void logout(){
        userAns.setId(0);
        userAns.setFname("");
        userAns.setLname("");
        userAns.setLoginSucces(false);
        userAns.setPass_expiration(0);
        userAns.setType(0);
    }
    
    
    //SPRAWDZA CZY PRZY ZMIANIE HASŁA PODANO POPRAWNE STARE HASŁO
    public Boolean checkPass(String pass, int userId){
        Boolean ans = false;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT user_pass FROM user_tab WHERE user_id=?"
            );
            conn.stmt.setInt(1, userId);
            conn.result = conn.stmt.executeQuery();
            conn.result.last();
            if (pass.equals(conn.result.getString("user_pass"))){
                ans = true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
        conn.disconnect();
        return ans;
    }
    
    
    //LOGOWANIE UŻYTKOWNIKA
    public UserEntity login(String log, String pas){
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
            userAns.setId(conn.result.getInt("user_id"));
            userAns.setFname(conn.result.getString("user_fname"));
            userAns.setLname(conn.result.getString("user_lname"));
            userAns.setType(conn.result.getInt("user_type"));
            userAns.setPass_expiration(conn.result.getLong("user_pass_expiration"));
            userAns.setLoginSucces(true);
        }
        catch(SQLException e){
            e.printStackTrace();
            userAns.setLoginSucces(false);
        }
        conn.disconnect();
        return userAns;
    }
    
    //SPRAWDZA CZY LOGIN WYSTĘPUJE JUŻ W BAZIE
    public Boolean loginExist(String login){
        Boolean ans = false;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement("select count(*) as cn from "
                    + "user_tab where user_login=?");
            conn.stmt.setString(1, login);
            conn.result = conn.stmt.executeQuery();
            conn.result.last();
            System.out.println(conn.result.getInt("cn"));
            if(conn.result.getInt("cn") == 1){
                ans = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ans;  
    };
    
    //SPRAWDZA CZY AKTUALNY CZAS WIĘKSZY NIŻ CZAS HASŁA W BAZIE
    public Boolean checkTimePass(long czas, int userId){
        Boolean ans = false;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT user_pass_expiration FROM user_tab WHERE user_id=?"
            );
            conn.stmt.setInt(1, userId);
            conn.result = conn.stmt.executeQuery();
            conn.result.last();
            if (czas > conn.result.getLong("user_pass_expiration")){
                ans = true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
        conn.disconnect();
        return ans;
    }
    
    //ZMIENIA HASŁO W BAZIE
    public void changePass(long czas, int userId, String newPass){
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "update user_tab set user_pass_expiration=?, user_pass=? where user_id=?"
            );
            conn.stmt.setLong(1, czas);
            conn.stmt.setString(2, newPass);
            conn.stmt.setInt(3, userId);
            conn.stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
            userAns.setLoginSucces(false);
        }        
        conn.disconnect();
    }
    
    public List<userType> getTypes(){
        List<userType> ans = new ArrayList<>();
        int id;
        String name;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT user_type_id, user_type_name FROM user_type_tab"
            );
            conn.result = conn.stmt.executeQuery();
            while(conn.result.next()){
                id = conn.result.getInt("user_type_id");
                name = conn.result.getString("user_type_name");
                ans.add(new userType(id,name));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
        conn.disconnect();
        return ans;
    }
    
    public void addUser(String fname, String lname, String login, String pass, String type){
        conn.connect();
        int typId=0;
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT user_type_id FROM user_type_tab WHERE user_type_name=?"
            );
            conn.stmt.setString(1, type);
            conn.result = conn.stmt.executeQuery();
            conn.result.last();
            typId= conn.result.getInt("user_type_id");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                "INSERT INTO user_tab(user_fname, user_lname, user_login, user_pass, user_type, user_pass_expiration)"
                        + "VALUES(?,?,?,?,?,?)");
            conn.stmt.setString(1, fname);
            conn.stmt.setString(2, lname);
            conn.stmt.setString(3, login);
            conn.stmt.setString(4, pass);
            conn.stmt.setInt(5, typId);
            conn.stmt.setLong(6, 1);
            conn.stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
        conn.disconnect();
    }
}
