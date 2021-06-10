package com.example.seg2105_term_project;
import androidx.appcompat.app.AppCompatActivity;

public class VerifyLogin extends AppCompatActivity {

    String user;
    String password;

    public VerifyLogin(String user,String password){
        this.user = user;
        this.password = password;
    }

    public boolean verified(MyDBHandler myDBHandler){
        if(myDBHandler.findProduct(this.user)!=null){
            return true;
        }else{
            return false;
        }
    }

    public int roleNumber(MyDBHandler myDBHandler) {
        if (myDBHandler.findProduct(user).getRole().equals("admin")) {
            return 0;
        } else if (myDBHandler.findProduct(user).getRole().equals("instructor")) {
            return 1;
        } else if (myDBHandler.findProduct(user).getRole().equals("student")) {
            return 2;
        } else {
            return -1;
        }
    }

    public String getRoleName(MyDBHandler myDBHandler){
        if(myDBHandler.findProduct(user)!=null){
            return myDBHandler.findProduct(user).getRole();
        }
        return null;
    }

}
