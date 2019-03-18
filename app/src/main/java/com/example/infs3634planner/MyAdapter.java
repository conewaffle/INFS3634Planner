package com.example.infs3634planner;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<WeekDetail> mDataset;

    public MyAdapter(ArrayList<WeekDetail> myDataset){
        mDataset = myDataset;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView weekterm;
        public TextView lab;
        public TextView lec;
        public TextView date;
        public CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);
            weekterm =itemView.findViewById(R.id.termWeek);
            lab = itemView.findViewById(R.id.textLab);
            lec = itemView.findViewById(R.id.textLec);
            date = itemView.findViewById(R.id.textDate);
            cardView = itemView.findViewById(R.id.cardView);
        }

    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        MyViewHolder vh =new MyViewHolder(myView);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.cardView.setCardBackgroundColor(Color.argb(255,13,71,161));

        holder.date.setText("Mon " + mDataset.get(position).getDateString() + " - " + mDataset.get(position).getDateEnd());

        holder.lab.setText("Lab: " + mDataset.get(position).getLab());
        holder.lec.setText("Lecture: " + mDataset.get(position).getLec());
        holder.weekterm.setText(mDataset.get(position).getWeekNo());

        if(mDataset.get(position).getLec().equals("N/A")){
            holder.lab.setText("No Class");
            holder.cardView.setCardBackgroundColor(Color.argb(255,120,144,156));
            holder.lec.setText(" ");
        }

        if(mDataset.get(position).getWeekNo().equals("Study")||mDataset.get(position).getWeekNo().equals("Exams")){
            holder.cardView.setCardBackgroundColor(Color.argb(255,136,14,79));
        }

        if (mDataset.get(position).getWeekNo().equals("N/A")){holder.weekterm.setText("Break");}


    }

    @Override
    public int getItemCount(){
        return mDataset.size();
    }


}
