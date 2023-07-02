package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ConfirmationBooking extends AppCompatActivity implements MyAdapter.RecyclerViewClickListener {

    RecyclerView recyclerView;
    TextView confirmation, totalPriceView;
    busTimes outBound;
    busTimes returnTime;
    Button checkJourney;
    Button goToPayment;
    MyAdapter myAdapter;
    ArrayList<busTimes>confirmTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_booking);
        Intent intent = getIntent();
        outBound = (busTimes)intent.getSerializableExtra("outbound");
        returnTime = (busTimes)intent.getSerializableExtra("return");

        double outBoundPrice = Double.parseDouble(outBound.getPrice());
        double returnPrice = Double.parseDouble(returnTime.getPrice());

        double totalPrice = outBoundPrice + returnPrice;
        String totalPriceString = Double.toString(totalPrice);
        totalPriceView = (TextView) findViewById(R.id.textView_price);
        totalPriceView.setText("Amount to pay: " + "£"+totalPriceString);


        checkJourney = (Button) findViewById(R.id.button_back_main);
        goToPayment = (Button) findViewById(R.id.button_to_pay);

        recyclerView = findViewById(R.id.recycler_view_confirm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        confirmTimes=new ArrayList<>();
        confirmTimes.add(outBound);
        confirmTimes.add(returnTime);
        myAdapter = new MyAdapter(ConfirmationBooking.this,confirmTimes, this);
        recyclerView.setAdapter(myAdapter);


    }

    @Override
    public void onClick(int position) {

    }

    public void gotoPayment(View view){
        Intent intent = new Intent(this, pay_frag.class
        );
        intent.putExtra("outbound", outBound);
        intent.putExtra("return", returnTime);
        startActivity(intent);
    }

    public void changeJourney(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}