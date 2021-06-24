package com.example.seg2105_term_project;

public class User {
    private String username;
    private String password;
    private int id;
    private String role;
    public User(){

    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void setUsername(String user){
        this.username = user;
    }
    public void setPassword(String pass){
        this.password = pass;
    }
    public void setID(int id){
        this.id=id;
    }
    public void setRole(String role){ this.role = role;}
    public String getUsername(){ return this.username; }
    public String getPassword(){
        return this.password;
    }
    public String getRole() { return this.role;}

}
