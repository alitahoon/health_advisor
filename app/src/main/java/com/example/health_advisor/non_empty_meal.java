package com.example.health_advisor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link non_empty_meal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class non_empty_meal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView RCV_meals;
    ArrayList<meal> meals=new ArrayList<meal>();
    TextView main_txt;
    Animation anim;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public non_empty_meal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment non_empty_meal.
     */
    // TODO: Rename and change types and number of parameters
    public static non_empty_meal newInstance(String param1, String param2) {
        non_empty_meal fragment = new non_empty_meal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_non_empty_meal, container, false);
        RCV_meals=v.findViewById(R.id.RCV_meals);
        main_txt=v.findViewById(R.id.main_text_fav);
        for (int i=0;i<100;i++)
        {
            meals.add(new meal("meal1","diabits",3,"Koshary is Read More.."
                    ,R.drawable.koshery));
        }
        meals_adapter newAdapter=new meals_adapter(meals);
        RCV_meals.setHasFixedSize(true);
        RCV_meals.setAdapter(newAdapter);
        anim= AnimationUtils.loadAnimation(getContext(),R.anim.scal);
//        RCV_meals.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
////                main_txt.startAnimation(anim);
//                main_txt.setVisibility(View.GONE);
//                return false;
//            }
//        });
        return v;
    }
}