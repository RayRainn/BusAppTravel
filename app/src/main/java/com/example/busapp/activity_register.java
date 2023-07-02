package com.example.busapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class activity_register extends AppCompatActivity {//Class and methods for activity_register activity.

    private FirebaseAuth mAuth;
    Button back;
    Button register;
    private EditText fullName, StudentId, emailAddress, Password;


    /*OnCreate method, initialises all the editTexts and Buttons in the activity.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        back = (Button) findViewById(R.id.button_register_back);
        register = (Button) findViewById(R.id.button_register_addUser);
        mAuth = FirebaseAuth.getInstance();

        fullName = (EditText) findViewById(R.id.register_fullname);
        StudentId = (EditText) findViewById(R.id.register_studentID);
        emailAddress = (EditText) findViewById(R.id.register_email);
        Password = (EditText) findViewById(R.id.register_password);

        Password = (EditText) findViewById(R.id.register_password);
    }

    /*Method set to onclick of the back button in activitiy_register.xml. Returns the user to the WelcomeActivity page.*/
    public void backToSignIn(View view){
        startActivity(new Intent(this, WelcomeActivity.class));
    }


    /*Method set to onclick of the register button in activity_register.xml. Checks the editText fields against
    * various rules and conditions to make sure user entries are valid, then creates an instance of user that
    * is added to the Firebase authentication and realtime database system. We also account for university email
    * addresses by adding the condition that a user can only sign up with a ac.uk email address.*/
    public void registerUser(View view){

        String nameString = fullName.getText().toString().trim();
        String sIDString = StudentId.getText().toString().trim();
        String emailString = emailAddress.getText().toString().trim();
        String passwordString = Password.getText().toString().trim();

        if(nameString.isEmpty()){
            fullName.setError("Please include your full name.");
            fullName.requestFocus();
            return;
        }

        if(sIDString.isEmpty()){
            StudentId.setError("Please include your Student ID.");
            StudentId.requestFocus();
            return;
        }
        if(emailString.isEmpty()){
            emailAddress.setError("Please include your email address.");
            emailAddress.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailString).matches()){
            emailAddress.setError("Please provide a valid email address");
            emailAddress.requestFocus();
            return;
        }

        if(!emailString.contains("ac.uk")){
          emailAddress.setError("Please provide valid student email.");
          emailAddress.requestFocus();
          return;
         }

        if(passwordString.isEmpty()){
            Password.setError("Please set a password of six or more characters.");
            Password.requestFocus();
            return;
        }

        if(passwordString.length()<6){
            Password.setError("Password must be six or more characters.");
            Password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    /*Creates the user instance, gets the unique Id from Firebase and assigns it to that user, who is
                    * then added to the authentication. Inner method checks if task has been carried out successfully.*/
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(nameString, sIDString, emailString, passwordString);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(activity_register.this, SignIn.class));
                                        Toast.makeText(getBaseContext(), "Registration Successful.",
                                                Toast.LENGTH_LONG).show();


                                    }
                                    else{
                                        Toast.makeText(getBaseContext(), "Registration failed. You may already be registered. Please try logging in.",
                                                Toast.LENGTH_LONG).show();

                                    }

                                }
                            });

                        }else{
                            Toast.makeText(activity_register.this, "Registration failed. You may already be registered. Please try logging in.",
                                    Toast.LENGTH_LONG).show();
                    }
                }});
    }

}
/*<!--Team 17 - Register activity code
@Author: Julian Laffin -->*/