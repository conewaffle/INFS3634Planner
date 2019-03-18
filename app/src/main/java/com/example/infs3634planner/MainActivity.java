package com.example.infs3634planner;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setTitle("INFS3634 Schedule 2019");

        ArrayList<WeekDetail> myDataset = WeekDetail.getWeekDetail();

        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);

        LocalDate today = LocalDate.now();
        int day = today.getDayOfYear();

        int position = 0;
        for(int i=0; i<53; i++){
            if(myDataset.get(i).getDate().getDayOfYear()<=day){
                position = i;
            }

        }

        recyclerView.smoothScrollToPosition(position);
    }

    public void search(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.business.unsw.edu.au/degrees-courses/course-outlines/archives/INFS3634-2019-T1#course-schedule"));
        startActivity(i);
    }
}
