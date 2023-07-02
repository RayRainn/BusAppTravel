package com.example.busapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


class SpinAdapter extends ArrayAdapter<String> {

    public Context context;
    List<String> castlelist;

    // Constructor accepts Context (from MainActivity) and a list of state abbreviations
    public SpinAdapter(Context context, int my_selected_item, List<String> cst) {
        super(context, R.layout.my_selected_item, cst);
        this.context = context;
        this.castlelist = cst;
    }

    // Override these methods and instead return our custom view (with image and text)
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // Function to return our custom View (View with an image and text)
    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.my_dropdown_item, parent, false);

        // Image and TextViews
        TextView castle1 = row.findViewById(R.id.text);
        ImageView cpic = row.findViewById(R.id.img);

        // Get castle image from drawables folder
        Resources res = context.getResources();
        String drawableName = castlelist.get(position).toLowerCase(); // tx
        int resId = res.getIdentifier(drawableName, "drawable", context.getPackageName());
        Drawable drawable = res.getDrawable(resId);

        //Set state abbreviation and state flag
        castle1.setText(castlelist.get(position));
        cpic.setImageDrawable(drawable);

        return row;
    }

}