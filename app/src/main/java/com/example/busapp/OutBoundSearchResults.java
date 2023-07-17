package com.example.busapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OutBoundSearchResults extends AppCompatActivity implements MyAdapter.RecyclerViewClickListener {


    RecyclerView recyclerView;
    ArrayList<busTimes> busTimesArrayList;
    MyAdapter myAdapter;
    DatabaseReference database;
    String castleselected;


    Button backToPlanTrip;
    Button continueToReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_bound_search_results);

        Intent intent = getIntent();
        castleselected = intent.getStringExtra("castle name");
        Toast.makeText(this, castleselected, Toast.LENGTH_LONG).show();
        //Is it possible that instead of using the spinner, we have buttons/images to choose from
        //which upon being clicked, set the string value that can then be compared?


        recyclerView = findViewById(R.id.recycler_view_outbound);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance().getReference("AlnwickNewcastleMon-Fri").getParent();
        busTimesArrayList = new ArrayList<>();
        myAdapter = new MyAdapter(OutBoundSearchResults.this,busTimesArrayList, this);
        recyclerView.setAdapter(myAdapter);



        ArrayList<String> nodes = new ArrayList<>();
        nodes.add("NewcastleAlnwickMon-Fri");
        nodes.add("AucklandNewcastleMon-Fri");
        nodes.add("NewcastleBishopAucklandMon-Fri");
        nodes.add("BishopAucklandBarnardMon-Fri");


        String passNode = new String();

        switch(castleselected){
            case "Alnwick Castle":
                passNode = nodes.get(0);
                break;

            case "Auckland Castle":
                passNode = nodes.get(1);
                break;

            case "Bamburgh Castle":
                passNode = nodes.get(2);
                break;

            case "Barnard Castle":
                passNode = nodes.get(3);
        }

        String referenceString = passNode;


        database.child(referenceString).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    busTimes busTimes = dataSnapshot.getValue(busTimes.class);

                    busTimesArrayList.add(busTimes);

                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ArrayList<busTimes> Bamburgh = new ArrayList<>();
        ArrayList<busTimes> Barnard = new ArrayList<>();


        for(busTimes connection: busTimesArrayList){

            if(connection.getDestinationEnd().equals("Berwick Upon Tweed")) {
                Bamburgh.add(connection);
            }

            else if(connection.getDestinationEnd().equals("Barnard Castle")){
                Barnard.add(connection);
            }

        }




    }






    @Override
    public void onClick(int position) {
        busTimesArrayList.get(position);
        busTimes sendTimes = busTimesArrayList.get(position);

        Log.d("sup", "This has been clicked");//This works!
        Intent intent = new Intent(this,ReturnSearchResults.class);
        intent.putExtra("destination",sendTimes);
        startActivity(intent);

    }
}