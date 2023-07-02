package com.example.busapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ThankYou extends AppCompatActivity implements MyAdapter.RecyclerViewClickListener {

    RecyclerView confirmedJourney;
    ArrayList<busTimes> busTimesconfirmedjourney;
    busTimes outBound;
    busTimes returnTime;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        Intent intent1 = getIntent();

        outBound = (busTimes) intent1.getSerializableExtra("outbound");
        returnTime = (busTimes) intent1.getSerializableExtra("return");

        confirmedJourney = (RecyclerView)findViewById(R.id.recycler_view_confirmedJourney);
        busTimesconfirmedjourney = new ArrayList<>();


        confirmedJourney.setHasFixedSize(true);
        confirmedJourney.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this,busTimesconfirmedjourney,this);
        confirmedJourney.setAdapter(myAdapter);


    }

    @Override
    public void onClick(int position) {

    }
}