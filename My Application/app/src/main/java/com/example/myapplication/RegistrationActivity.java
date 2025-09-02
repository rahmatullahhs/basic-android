package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {
private EditText mEmail ;
private EditText mPass;
private Button btnRed;
private TextView mSingin;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
registrition();

    }
    private void registrition(){

        mEmail=findViewById(R.id.email_register);
        mPass=findViewById(R.id.password_register);
        btnRed=findViewById(R.id.btn_register);
        mSingin=findViewById(R.id.signup_reg);









    }





}