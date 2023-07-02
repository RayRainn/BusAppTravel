package com.example.busapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.busapp.databinding.FragmentFirstBinding;

public class fragt extends Fragment {
    /*ImageButton bambi;
    ImageButton barn;
    ImageButton aln;
    ImageButton auck;*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        ImageButton bambi = (ImageButton) view.findViewById(R.id.bamburghbutton);
        ImageButton barn = (ImageButton) view.findViewById(R.id.barnbutton);
        ImageButton aln = (ImageButton) view.findViewById(R.id.alnwickbutton);
        ImageButton auck = (ImageButton) view.findViewById(R.id.aucklandbutton);

        auck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent inp3 = new Intent(getActivity(), auckland.class);
                startActivity(inp3);
            }
        });


        barn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inp = new Intent(getActivity(), barnard.class);
                startActivity(inp);//this will run the payment activity on button click Check availability
            }
        });


        aln.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent inp2 = new Intent(getActivity(), alnwick.class);
                startActivity(inp2);
            }
        });


        bambi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent inp4 = new Intent(getActivity(), bamburgh.class);
                startActivity(inp4);//this will run the payment activity on button click Check availability


            }
        });


        return view;
    }
}




