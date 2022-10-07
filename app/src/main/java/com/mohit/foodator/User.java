package com.mohit.foodator;

import android.widget.EditText;

public class User {
    public String fullName;
    public String email;

    public User(String fullName, EditText email){

    }

    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
}
