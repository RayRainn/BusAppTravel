package com.example.busapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import com.example.busapp.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.zip.Inflater;
/*
Broken Nav Drawer in activity main
<com.google.android.material.navigation.NavigationView
            android:layout_width="412dp"
            android:layout_height="match_parent"
            app:headerLayout="@id/nav_extra"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:menu="@menu/menu_nav">

        </com.google.android.material.navigation.NavigationView>
*/
/*public class MainActivity extends AppCompatActivity {
                    //
                    //
                    //
                    //
                    //    @Override
                    //    protected void onCreate(Bundle savedInstanceState) {
                    //        super.onCreate(savedInstanceState);
                    //
                    //        binding = ActivityMainBinding.inflate(getLayoutInflater());
                    //        setContentView(binding.getRoot());
                    //
                    //
                    //        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
                    //        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
                    //        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
                    //
                    //
                    //         /*Toolbar toolbar = findViewById(R.id.toolbar);
                    //        setSupportActionBar(toolbar);
                    //
                    //        FloatingActionButton fab = findViewById(R.id.fab);
                    //        //pulling from the button made in nav header
                    //        fab.setOnClickListener(new View.OnClickListener() {
                    //                                   @Override
                    //                                   public void onClick(View view) {
                    //                                       Snackbar.make(view, "Test", Snackbar.LENGTH_LONG)
                    //                                               .setAction("Test 2", null).show();
                    //
                    //                                   }
                    //                               });
                    //
                    //        //DrawerLayout drawer = findViewById(R.id.constraintLayout);
                    //        //NavigationView navigationView = findViewById(R.id.my_nav);
                    //
                    //        //mAppBarConfiguration = new AppBarConfiguration.Builder(
                    //        //    R.id.fl1, R.id.fl2)
                    //        //        .setDrawerLayout(drawer)
                    //        //        .build();
                    //
                    //        NavController navController = Navigation.findNavController(this, R.id.my_nav);
                    //        NavigationUI.setupActionBarWithNavController(this,navController,mAppBarConfiguration);
                    //        NavigationUI.setupWithNavController(navigationView, navController);
                    //
                    //                    //PlaceHolder o see if it goes
                    */

// Basically the main method for the Activity_main.xml layout file
public class MainActivity extends AppCompatActivity implements View.OnClickListener /*implements AdapterView.OnItemSelectedListener*/ {

    //private Spinner spinner;

    ActivityMainBinding binding;

    BottomNavigationView bottomNavigationView; //initializing the bottom nav bar from activity_main again
    @Override
    protected void onCreate(Bundle savedInstanceState) {//changing content which is based on the activity_main class, think of activity_main as the  main driver class, where everything is activated at
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());






        /*spinner = findViewById(R.id.spinnerde);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.destination1, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);*/




        // We are taking the R.ID which is the view in the activity xml and replacing fragments (pages)



        bottomNavigationView = findViewById(R.id.bnv);//bnv is the id of my Nav bar, thats being found in activity main
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override //Simple switch statements to go between certain pages, these get effected by the Navigation actions which are linked to the buttons you click, The code is in
            //the navigation folder - my_nav code section
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.fl1:
                        fragment= new FirstFragment();
                        break;
                    case R.id.fl2://ids of the fragments those are in their own xmls or nav_graph
                        fragment= new SecondFragment();
                        break;
                    case R.id.fl3:
                        fragment= new frag3();
                        break;

                    case R.id.fl4:
                        fragment = new frag4();
                        break;


                    case R.id.fl5:
                        fragment = new fragt();
                        break;

                    //THIS IS TEMPORARY, DELETE THIS CASE WHEN CHECKER REPLACES THE LOGIN AND NOT LOGGED IN STATE
                }



                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
                return true;
            }
        });
    }
    //This one.
    @Override
    public void onClick(View view) {

        switch(view.getId()){


        }
    }

}


    /*@Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/


/* Team 17 Project: CastleLine  - Main activity_main class main functionality
@Author - Royce Barker and Julian Laffin
 */
