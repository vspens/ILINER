package com.iliner.myapplication.FirebaseUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.iliner.myapplication.HomeActivity;
import com.iliner.myapplication.MainActivity;

public class FirebaseUtils {
    public static FirebaseAuth firebaseAuth;
    public static FirebaseUser user;

}
