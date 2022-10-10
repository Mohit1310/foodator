package com.mohit.foodator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ForgotPwdActivity extends AppCompatActivity {

    private EditText emailFP;
    private EditText newPwd, confNewPwd;
    private Button resetPwd;
    private TextView loginHere;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);

        mAuth = FirebaseAuth.getInstance();

        emailFP = findViewById(R.id.emailReset);
//        newPwd = findViewById(R.id.pwdReset);
//        confNewPwd = findViewById(R.id.confirmPass);
        resetPwd = findViewById(R.id.resetPwd);
        loginHere = findViewById(R.id.login_here);

        loginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPwdActivity.this,LoginActivity.class));
                finish();
            }
        });

    }
}