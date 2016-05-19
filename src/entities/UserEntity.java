/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Marek
 */
public class UserEntity {
    int id;
    String fname;
    String lname;
    int type;
    long pass_expiration;
    boolean loginSucces;

    public boolean isLoginSucces() {
        return loginSucces;
    }

    public void setLoginSucces(boolean loginSucces) {
        this.loginSucces = loginSucces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getPass_expiration() {
        return pass_expiration;
    }

    public void setPass_expiration(long pass_expiration) {
        this.pass_expiration = pass_expiration;
    }
    
    
}
