package com.example.busapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;


public class pay_frag extends AppCompatActivity {

    CardForm cardForm;
    Button pay;
    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_paymentpg);

        cardForm = findViewById(R.id.card_form); //using brain trees card forms style
        pay = findViewById(R.id.btnBuy);
        cardForm.cardRequired(true)//attributes which will show on the fragments
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("Please Start with 0 for the number                                         " +
                        "SMS is required on this number")

                .setup(pay_frag.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        pay.setOnClickListener(new View.OnClickListener() {


            //pop up msgs before u buy
            @Override
            public void onClick(View view) {
                if (cardForm.isValid()) {
                    alertBuilder = new AlertDialog.Builder(pay_frag.this);
                    alertBuilder.setTitle("Confirm before purchase");
                    alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                            "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "Card CVV: " + cardForm.getCvv() + "\n" +
                            "Postal code: " + cardForm.getPostalCode() + "\n" +
                            "Phone number: " + cardForm.getMobileNumber());
                    alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(pay_frag.this, "Thank you for purchase", Toast.LENGTH_LONG).show();

                            startActivity(new Intent(pay_frag.this, WelcomeActivity.class));
                        }
                    });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();

                } else {
                    Toast.makeText(pay_frag.this, "Please complete the form", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
/*<!--Team 17 - Payment Frag activity code
@Author: Royce Barker -->*/