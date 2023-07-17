package com.example.busapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.List;

public class spincontent extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> cst = Arrays.asList("Barnard_Castle", "Alnwick_Castle", "Auckland_Castle", "Bamburgh_Castle");
        final Spinner spinner = findViewById(R.id.sp2);

        // Our custom Adapter class that we created
        SpinAdapter adapter = new SpinAdapter(getApplicationContext(), R.layout.my_selected_item, cst);
        adapter.setDropDownViewResource(R.layout.my_dropdown_item);

        spinner.setAdapter(adapter);

        // Make a Toast whenever the user selects something from the Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newItem = cst.get(i);
                Toast.makeText(getApplicationContext(), "You selected: " + newItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        bottomNavigationView = findViewById(R.id.bnv);//bnv is the id of my Nav bar, thats being found in activity main
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            //Simple switch statements to go between certain pages, these get effected by the Navigation actions which are linked to the buttons you click, The code is in
            //the navigation folder - my_nav code section
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;


                switch (item.getItemId()) {
                    case R.id.fl5:
                        fragment = new fragt();
                        break;
                    case R.id.fl2://ids of the fragments those are in their own xmls or nav_graph
                        fragment = new SecondFragment();

                        break;
                    case R.id.fl3:
                        fragment = new frag3();
                        break;

                    case R.id.fl4:
                        fragment = new frag4();
                        break;

                }


                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
                return true;
            }
        });
      }

    }

