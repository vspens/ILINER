package com.iliner.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.iliner.myapplication.FirebaseUtils.FirebaseUtils.firebaseAuth;

public class RegisterUserActivity extends Activity {
    FirebaseAuth firebaseAuth;
    EditText regEmail;
    EditText regPass;
    EditText regName;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);
        firebaseAuth = FirebaseAuth.getInstance();

        regName = findViewById(R.id.regName);
        regEmail = findViewById(R.id.regEmail);
        regPass = findViewById(R.id.regPassword);
        btnRegister = findViewById(R.id.btnRegister);

        initializeListeners();
    }

    protected void initializeListeners(){

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Signup();
            }
        });
    }

    private void Signup() {
        String email = regEmail.getText().toString();
        String password = regPass.getText().toString();
        String name = regName.getText().toString();

        try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterUserActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(RegisterUserActivity.this, "Signup error", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        Toast.makeText(RegisterUserActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}