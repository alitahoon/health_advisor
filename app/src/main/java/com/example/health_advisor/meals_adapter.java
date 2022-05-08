package com.example.health_advisor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;

public class meals_adapter extends RecyclerView.Adapter<meals_adapter.meals> {
    ArrayList<meal> meals_list;

    public meals_adapter(ArrayList<meal> meals_list) {
        this.meals_list = meals_list;
    }

    @NonNull
    @Override
    public meals onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.meals_layout,null,false);
        meals newMeals=new meals(v);
        return newMeals;
    }

    @Override
    public void onBindViewHolder(@NonNull meals holder, int position) {
            meal newMeal=meals_list.get(position);
            holder.m_name.setText(newMeal.getName());
            holder.m_categorie.setText(newMeal.getCategorie());
            holder.m_img.setImageResource(newMeal.getImg());
            holder.m_rate.setRating(newMeal.getRate());
            holder.m_details.setText(newMeal.getDetails());
    }

    @Override
    public int getItemCount() {
        return meals_list.size();
    }

    class meals extends RecyclerView.ViewHolder {
        TextView m_name;
        TextView m_details;
        ImageView m_img;
        RatingBar m_rate;
        TextView m_categorie;
        public meals(@NonNull View itemView) {
            super(itemView);
            m_name=itemView.findViewById(R.id.meal_name);
            m_details=itemView.findViewById(R.id.meal_detials);
            m_img=itemView.findViewById(R.id.meal_img);
            m_rate=itemView.findViewById(R.id.meal_rate);
            m_categorie=itemView.findViewById(R.id.meal_categoriy_name);
        }
    }
}
