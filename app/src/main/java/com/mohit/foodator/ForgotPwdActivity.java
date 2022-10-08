package com.mohit.foodator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPwdActivity extends AppCompatActivity {

    private EditText emailFP, newPwd, confNewPwd;
    private Button resetPwd;
    private TextView loginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);

        emailFP = findViewById(R.id.emailReset);
        newPwd = findViewById(R.id.pwdReset);
        confNewPwd = findViewById(R.id.confirmPass);
        resetPwd = findViewById(R.id.resetPwd);
        loginHere = findViewById(R.id.login_here);


    }
}