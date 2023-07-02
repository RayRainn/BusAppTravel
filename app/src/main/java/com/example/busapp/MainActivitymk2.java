package com.example.busapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivitymk2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    BottomNavigationView bottomNavigationView2;
    Button findTimes;
    ArrayList<busTimes> busTimesArrayList;
    DatabaseReference database;
    Spinner destination;
    List<String> castles;
    String castleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);
        database = FirebaseDatabase.getInstance().getReference("AucklandNewcastleMon-Fri").getParent();
        busTimesArrayList = new ArrayList<>();

        destination = (Spinner) findViewById(R.id.sp2);
        String[] castleNames = {"Alnwick Castle", "Auckland Castle", "Bamburgh Castle", "Barnard Castle"};
        castles = new ArrayList<>(Arrays.asList(castleNames));

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.my_selected_item, castles);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destination.setAdapter(dataAdapter);

        destination.setOnItemSelectedListener(this);

        findTimes = (Button) findViewById(R.id.buttonSecond);
        findTimes.setOnClickListener(this);


    }



        @Override
        public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
            castleName = castles.get(position);
            Toast.makeText(MainActivitymk2.this, castleName + " selected", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected (AdapterView < ? > parent){

        }

        @Override
        public void onClick (View v){

            String castleQuery = castleName;
            Intent intent = new Intent(this, OutBoundSearchResults.class);
            intent.putExtra("castle name", castleQuery);
            startActivity(intent);

        }

    }






