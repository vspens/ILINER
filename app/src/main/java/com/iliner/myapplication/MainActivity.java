package com.iliner.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    public EditText email;
    public EditText password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FirebaseApp.initializeApp(this);
        // Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("iliner");
        //myRef.setValue("Hello, World!");

        setContentView(R.layout.login);
        firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);

        initializeListeners();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    protected void initializeListeners(){

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login(){
        String strEmail = email.getText().toString();
        String strPass = password.getText().toString();
        try {
            firebaseAuth.signInWithEmailAndPassword(strEmail, strPass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "sign in error", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                    }
                }
            });
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

}
