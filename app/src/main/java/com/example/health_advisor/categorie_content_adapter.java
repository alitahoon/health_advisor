package com.example.health_advisor;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class categorie_content_adapter extends RecyclerView.Adapter<categorie_content_adapter.cat_content> {
    ArrayList<categorie_content> contents_lists;
    onRecycleViewItemClickListener listener;

    public categorie_content_adapter(ArrayList<categorie_content> contents_lists,onRecycleViewItemClickListener listener) {
        this.contents_lists = contents_lists;
        this.listener=listener;
    }

    @NonNull
    @Override
    public cat_content onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.categorie_content_layout,null,false);
       cat_content newContent=new cat_content(v);
        return newContent;
    }

    @Override
    public void onBindViewHolder(@NonNull cat_content holder, int position) {
        categorie_content new_cat_con=contents_lists.get(position);
        holder.con_cat_name.setText(new_cat_con.getCategorie_name());
        holder.con_cat_rate.setRating(new_cat_con.getRate());
        holder.con_detial.setText(new_cat_con.getDetails());
        holder.con_img.setImageResource(new_cat_con.getImg());
        holder.con_name.setText(new_cat_con.getName());
        holder.con_ID=new_cat_con.getId();
        holder.cat_content_card.setCardBackgroundColor(Color.parseColor(new_cat_con.getColor()));
    }

    @Override
    public int getItemCount() {
        return contents_lists.size();
    }

    class cat_content extends RecyclerView.ViewHolder {
        ImageView con_img;
        TextView con_name;
        TextView con_detial;
        TextView con_cat_name;
        RatingBar con_cat_rate;
        CardView cat_content_card;
        LottieAnimationView lot_fav;
        Boolean startAnime=false;
        int con_ID;
        public cat_content(@NonNull View itemView) {
            super(itemView);
            con_img=itemView.findViewById(R.id.image_cat_content);
            con_cat_name=itemView.findViewById(R.id.categoriy_name_cat_content);
            con_detial=itemView.findViewById(R.id.details_cat_content);
            con_name=itemView.findViewById(R.id.name_cat_content);
            lot_fav=itemView.findViewById(R.id.lot_fav_animation_cat_content);
            con_cat_rate=itemView.findViewById(R.id.ratebar_cat_con);
            cat_content_card=itemView.findViewById(R.id.cat_content_cardView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClickListener(con_ID);
                }
            });
            lot_fav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lot_fav.playAnimation();
                }
            });

        }
    }
}
