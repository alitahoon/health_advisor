package com.example.health_advisor;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link container_content#newInstance} factory method to
 * create an instance of this fragment.
 */
public class container_content extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String cat_name = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView RCV_diabets;
    String category_name ="Diabets Food";
    ArrayList<categorie_content> diabits_meals=new ArrayList<categorie_content>();
    // TODO: Rename and change types of parameters
    private String catName;
    private String mParam2;

    public container_content() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment container_content.
     */
    // TODO: Rename and change types and number of parameters
    public static container_content newInstance(String param1, String param2) {
        container_content fragment = new container_content();
        Bundle args = new Bundle();
        args.putString(cat_name, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            catName = getArguments().getString(cat_name);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        if (catName=="diabits_categorie"){
            diabits_meals.clear();
            diabits_meals.add(new categorie_content("vegetables",R.drawable.diabets_food_1,"vegetables with lots of added sodium",4,"Diabits Food",1,"#B5EAEA"));
            diabits_meals.add(new categorie_content("Veggies",R.drawable.diabets_food_2,"Veggies cooked with lots of added butter, cheese",2,"Diabits",2,"#B5EAEA"));
            diabits_meals.add(new categorie_content("Sauerkraut",R.drawable.diabets_food_3,"Sauerkraut, for the same reason as pickles. ",3,"Diabits",3,"#B5EAEA"));

        }else if(catName=="fitness_categorie"){
            diabits_meals.clear();
            diabits_meals.add(new categorie_content("Banana",R.drawable.fitness_food_1,"Don’t have much time before you head to the gym",4,"Fitness Food",1,"#C6EBC9"));
            diabits_meals.add(new categorie_content("Burger",R.drawable.fitness_food_2,"Whether you sometimes try a meat-free meal or stick ",2,"Fitness",2,"#C6EBC9"));
            diabits_meals.add(new categorie_content("Chicken ",R.drawable.fitness_food_3,"When you exercise regularly, you need more protein",5,"Fitness",3,"#C6EBC9"));

        }else if(catName=="hypertensive_categorie"){
            diabits_meals.clear();
            diabits_meals.add(new categorie_content("veggies",R.drawable.diabets_food_2,"Decreasing sodium intake is a well-established...",1,"hypertensive",1,"#FFBCBC"));
            diabits_meals.add(new categorie_content("Lentils",R.drawable.diabets_food_3,"Decreasing sodium intake is a well-established...",2,"hypertensive",2,"#FFBCBC"));
            diabits_meals.add(new categorie_content("Bengal ",R.drawable.diabets_food_1,"When you exercise regularly, you need more protein",4,"hypertensive",3,"#FFBCBC"));

        }else if(catName=="diet_categorie"){
            diabits_meals.clear();
            diabits_meals.add(new categorie_content("hhgdsfsdfh",R.drawable.diabets_food_2,"wedkkdehkdhwed",4,"fewf",1,"#BEDCFA"));
            diabits_meals.add(new categorie_content("vegatgfhfaball",R.drawable.diabets_food_3,"wedkkdehkdhwed",4,"fewf",2,"#BEDCFA"));
            diabits_meals.add(new categorie_content("dfsdf",R.drawable.diabets_food_1,"wedkkdehkdhwed",4,"fewf",3,"#BEDCFA"));
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_container_content, container, false);
        //assignments
        RCV_diabets=v.findViewById(R.id.RCV_diabets);
        categorie_content_adapter new_cat_adapter=new categorie_content_adapter(diabits_meals, new onRecycleViewItemClickListener() {
            @Override
            public void onItemClickListener(int cardID) {
                Toast.makeText(getActivity(), "ID = "+cardID, Toast.LENGTH_SHORT).show();
            }
        });
        RCV_diabets.setHasFixedSize(true);
        RCV_diabets.setAdapter(new_cat_adapter);
        Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
        return v;
    }
}