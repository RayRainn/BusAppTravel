package com.example.busapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<busTimes> busTimesArraylist;
    RecyclerViewClickListener recyclerViewClickListener;
    public MyAdapter(Context context, ArrayList<busTimes> busTimesArraylist, RecyclerViewClickListener listener) {
        this.context = context;
        this.busTimesArraylist = busTimesArraylist;
        this.recyclerViewClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.bustimes,parent,false);
        return new MyViewHolder(v,recyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        busTimes busTimes = busTimesArraylist.get(position);

        holder.DepartureTime.setText(busTimes.DepartureTime);
        holder.ArrivalTime.setText(busTimes.ArrivalTime);
        holder.DestinationStart.setText(busTimes.DestinationStart);
        holder.DestinationEnd.setText(busTimes.DestinationEnd);
        holder.Route.setText(busTimes.Route);
        holder.Price.setText("£" +busTimes.Price);

    }

    @Override
    public int getItemCount() {
        return busTimesArraylist.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView DepartureTime, ArrivalTime, DestinationStart, DestinationEnd, Route, Price;
        RecyclerViewClickListener listener;

        public MyViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            DepartureTime = itemView.findViewById(R.id.tvdepartureTime);
            ArrivalTime = itemView.findViewById(R.id.tvarrivalTime);
            DestinationStart = itemView.findViewById(R.id.tvdestinationStart);
            DestinationEnd = itemView.findViewById(R.id.tvdestinationEnd);
            Route = itemView.findViewById(R.id.tvroute);
            Price = itemView.findViewById(R.id.tvprice);
            this.listener=listener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(getAdapterPosition());


        }
    }

    public interface RecyclerViewClickListener{
        void onClick(int position);
    }


}
