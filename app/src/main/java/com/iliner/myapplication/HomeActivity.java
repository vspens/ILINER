package com.iliner.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends Activity {
    FirebaseAuth firebaseAuth;
    TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        firebaseAuth = firebaseAuth.getInstance();
        txtUser = findViewById(R.id.txtUser);

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null){
            txtUser.setText(currentUser.getEmail());
        } else {
            Toast.makeText(HomeActivity.this, "ERRORRRRRR", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {

    }
}
