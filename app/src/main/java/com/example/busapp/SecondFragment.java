package com.example.busapp;


import static android.view.View.GONE;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.busapp.databinding.FragmentSecondBinding;

import java.util.Arrays;
import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);


//Basically using my buttons on the plantrip fragment, and on click it will send the user to payment frag+activity
        Button but2 = (Button) view.findViewById(R.id.buttonSecond);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inp = new Intent(getActivity(),pay_frag.class);
                startActivity(inp);//this will run the payment activity on button click Check availability
            }
        });

        final List<String> cst = Arrays.asList("Barnard_Castle", "Alnwick_Castle", "Auckland_Castle", "Bamburgh_Castle");

        Spinner sp2 = (Spinner) view.findViewById(R.id.sp2);



        // ArrayAdapter that creates a View for each click in spinner

        SpinAdapter adapter = new SpinAdapter(getActivity(),R.layout.my_selected_item, cst);
        adapter.setDropDownViewResource(R.layout.my_dropdown_item);

        sp2.setAdapter(adapter);


        return view;
    }
}


/*<!--Team 17 - Second Fragment Code
@Author: Royce Barker */
