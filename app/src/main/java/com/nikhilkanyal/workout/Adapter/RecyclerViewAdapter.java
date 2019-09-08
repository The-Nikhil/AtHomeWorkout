package com.nikhilkanyal.workout.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nikhilkanyal.workout.Exercise;
import com.nikhilkanyal.workout.Interface.ItemClickListener;
import com.nikhilkanyal.workout.MainActivity;
import com.nikhilkanyal.workout.R;
import com.nikhilkanyal.workout.ViewExercise;

import java.util.List;

/**
 * Created by Nikhil kanyal on 5/6/2019.
 */

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public ImageView image;
    public TextView text;
    private ItemClickListener itemClickListener;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        image=(ImageView)itemView.findViewById(R.id.ex_img);
        text=(TextView)itemView.findViewById(R.id.ex_name);

        itemView.setOnClickListener(this);
    }


    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition());

    }
}
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    private List<Exercise>exerciseList;
    private Context context;

    public RecyclerViewAdapter(List<Exercise> exerciseList, Context context) {
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_exercise,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.image.setImageResource(exerciseList.get(position).getImage_id());
        holder.text.setText(exerciseList.get(position).getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //call to new Activity

               Intent intent=new Intent(context, ViewExercise.class);
                intent.putExtra("image_id",exerciseList.get(position).getImage_id());
                intent.putExtra("name",exerciseList.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
}
