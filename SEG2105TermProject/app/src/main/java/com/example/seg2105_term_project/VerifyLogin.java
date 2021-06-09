package com.example.seg2105_term_project;

import android.content.Context;

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

}
