package com.example.busapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainDriver extends AppCompatActivity {


    BottomNavigationView bottomNavigationView; //initializing the bottom nav bar from activity_main again
    RecyclerView recyclerView;

    ImageButton backb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bnv);//bnv is the id of my Nav bar, thats being found in activity main
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            //Simple switch statements to go between certain pages, these get effected by the Navigation actions which are linked to the buttons you click, The code is in
            //the navigation folder - my_nav code section
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;


                switch (item.getItemId()){


                    case R.id.fl2://ids of the fragments those are in their own xmls or nav_graph
                        fragment= new SecondFragment();

                        startActivity(new Intent(MainDriver.this, MainActivitymk2.class));

                    break;
                    case R.id.fl3:
                        fragment= new frag3();
                        break;

                    case R.id.fl4:
                        fragment = new frag4();
                        break;
                    case R.id.fl5:
                        fragment = new fragt();



                }


                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
                return true;
            }
        });




        /*List<castlesinfo> castledelist = new ArrayList<>();
        castledelist.add(new castlesinfo("Barnard Castle", R.drawable.bc1));
        castledelist.add(new castlesinfo("Bamburgh Castle", R.drawable.bc2));
        castledelist.add(new castlesinfo("Alnwick Castle", R.drawable.bc3));
        castledelist.add(new castlesinfo("Auckland Castle", R.drawable.bc4));


        setcastleview(castledelist);
    }


    private void setcastleview (List < castlesinfo > castledelist) {

        recyclerView = findViewById(R.id.castlere);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        castlesadapter = new castlesadapter(this, castledelist);
        recyclerView.setAdapter(castlesadapter);*/

    }





//This one.

    public void onClick(View view) {

        switch (view.getId()) {


        }
    }
}

/*<!--Team 17 - MainDriver activity code
@Author: Royce Barker -->*/

