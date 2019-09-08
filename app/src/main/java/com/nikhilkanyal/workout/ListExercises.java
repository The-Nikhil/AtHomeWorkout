package com.nikhilkanyal.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nikhilkanyal.workout.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListExercises extends AppCompatActivity {
    List<Exercise>exerciseList =new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercises);

        initdata();
        recyclerView =(RecyclerView)findViewById(R.id.list_ex);
        adapter= new RecyclerViewAdapter(exerciseList,getBaseContext());
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void initdata(){
        exerciseList.add(new Exercise(R.drawable.marchsteps,"March Steps"));
        exerciseList.add(new Exercise(R.drawable.jumpinglunges,"jumping lunges"));
        exerciseList.add(new Exercise(R.drawable.marchsteps2,"March Steps"));
        exerciseList.add(new Exercise(R.drawable.a3plank,"Plank"));
        exerciseList.add(new Exercise(R.drawable.a4plankrotation,"Plank Rotation"));
        exerciseList.add(new Exercise(R.drawable.a5plankhold2,"Plank Hold"));
        exerciseList.add(new Exercise(R.drawable.a6punches,"Punches"));
        exerciseList.add(new Exercise(R.drawable.a7pushups,"Pushups"));
        exerciseList.add(new Exercise(R.drawable.a8puncheslast,"Punches"));


    }
}
