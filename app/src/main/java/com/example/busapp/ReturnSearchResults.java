package com.example.busapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ReturnSearchResults extends AppCompatActivity implements MyAdapter.RecyclerViewClickListener {

    RecyclerView recyclerView;
    ArrayList<busTimes> busTimesArrayListReturns;
    MyAdapter myAdapter;
    DatabaseReference database;
    String passData;
    busTimes outBound;
    ArrayList<String> nodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_search_results);
        Intent intent= getIntent();
        outBound = (busTimes)intent.getSerializableExtra("destination");
        passData = outBound.getDestinationEnd();
        TextView title = (TextView)findViewById(R.id.textview_return_title);
        title.setText("Please choose a return journey from " + passData);



        recyclerView = findViewById(R.id.recycler_view_return);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance().getReference("AlnwickNewcastleMon-Fri").getParent();
        busTimesArrayListReturns = new ArrayList<>();
        myAdapter = new MyAdapter(ReturnSearchResults.this,busTimesArrayListReturns,this);
        recyclerView.setAdapter(myAdapter);

        String node1 = "AlnwickNewcastleMon-Fri";
        String node2 = "NewcastleAucklandMon-Fri";
        String node3 = "BamburghBelfordFirestationMon-Fri";
        String node4 = "BarnardBishopAucklandMon-Fri";


        String choice = new String();

        switch(passData){
            case "Alnwick Playhouse":
                choice = node1;
                break;

            case "Newcastle Eldon Square":
                choice = node2;
                break;

            case "Bishop Auckland Bus Station Stand C":
                choice = node3;
                break;

            case "Barnard Castle Galgate Stand B":
                choice = node4;
                break;

        }

        nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);

        String referenceString = choice;




        database.child(referenceString).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    busTimes busTimes = dataSnapshot.getValue(busTimes.class);
                    assert busTimes != null;
                    String[] returnTimes = busTimes.getDepartureTime().split(":");
                    int arrivalHour = Integer.parseInt(returnTimes[0]);
                    String[]outBoundArrivalTime = outBound.getArrivalTime().split(":");
                    int outBoundArrivalHour = Integer.parseInt(outBoundArrivalTime[0]);

                    if(arrivalHour>outBoundArrivalHour)
                        busTimesArrayListReturns.add(busTimes);



                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public void onClick(int position) {
        busTimes returnTime = busTimesArrayListReturns.get(position);
        Intent intent = new Intent(this, ConfirmationBooking.class);
        intent.putExtra("outbound", outBound);
        intent.putExtra("return", returnTime);
        startActivity(intent);
    }
}