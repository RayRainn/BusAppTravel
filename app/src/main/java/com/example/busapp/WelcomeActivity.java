package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {//Welcome Activity with two buttons that
    //allows the user to sign in or register an account with the app.




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fragment fragment = new FirstFragment();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
        //getSupportFragmentManager().beginTransaction().replace
                //(R.id.firstFragment,fragment).commit(); No longer needed to navigate,



    public void displayRegister(View view){
        startActivity(new Intent(this, activity_register.class));
    }

    public void goToSignIn(View view){
        startActivity(new Intent(this, SignIn.class));
    }



}



/*<!--Team 17 - Welcome activity code
@Author: Julian Laffin -->*/