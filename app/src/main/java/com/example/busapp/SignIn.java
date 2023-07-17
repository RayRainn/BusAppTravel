package com.example.busapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {//SignIn Activity Class.
    private Button btreg;
    private Button btsignIn;
    private EditText email, password;
    private FirebaseAuth mAuth;

    /*OnCreate method: initialises the above variables and sets the content view to the xml file.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btreg = (Button) findViewById(R.id.btreg);
        btsignIn = (Button) findViewById(R.id.btsign);

        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();
    }
    /*The below methods have been assigned via the onclick function in the xml document. When */
    public void displayRegister(View view){
        startActivity(new Intent(this, activity_register.class));
    }
    /*Assigned to the back button in the xml activity_sign_in class. Takes the user back to
    * welcome page. */
    public void displaySignInHome(View view){
        startActivity(new Intent(this,WelcomeActivity.class));
    }


    /*This method checks a user's unique firebase ID to see if it is present in the database and if so,
    * grants access to the rest of the application.*/
    public void signInCheck(View view) {

        String emailSignIn = email.getText().toString().trim();
        String passwordSignIn = password.getText().toString().trim();

        /*These checks make sure that a user enters valid sign in credentials. In the register class,
        * users are only permitted to sign up with an email address containing ac.uk, and so can only
        * use the app with a student email. Firebase will not accept passwords of 6 characters or less
        * and this is accounted for both here and in registration.*/

        if (emailSignIn.isEmpty()) {
            email.setError("Please enter your login email address.");
            email.requestFocus();
            return;
        }

        if (passwordSignIn.isEmpty()) {
            password.setError("Please enter your password.");
            password.requestFocus();
            return;
        }

        if (passwordSignIn.length() < 6) {
            password.setError("Password must be six or more characters.");
            password.requestFocus();
            return;
        }

        /*We sign in with the username and password and use an onCompleteListener to check whether
        * the task is done and if it is, take further action. If it is not, the user is directed back to
        * the welcome screen.*/
        mAuth.signInWithEmailAndPassword(emailSignIn, passwordSignIn).addOnCompleteListener
                (new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignIn.this, "Sign In Successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(SignIn.this, MainDriver.class));




                        } else {
                            Toast.makeText(SignIn.this, "Please try again.", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(SignIn.this, WelcomeActivity.class));

                        }
                    }


                });
    }
}

/*<!--Team 17 - Sign in activity code
@Author: Julian Laffin -->*/