package com.example.seg2105_term_project;

import java.util.ArrayList;

public class CurrentUser{
     private static String userName;
     private static String role;
     private static String password;
     public static void setUsername(String user) {
          userName = user;
     }

     public static void setPassword(String pass) {
          password = pass;
     }

     public static void setRole(String roles) {
          role = roles;
     }

     public static String getUsername() {
          return userName;
     }

     public static String getPassword() {
          return password;
     }

     public static String getRole() {
          return role;
     }

}
