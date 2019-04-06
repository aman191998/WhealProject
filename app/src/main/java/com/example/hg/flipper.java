package com.example.hg;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class flipper extends Fragment {


    public flipper() {
        // Required empty public constructor
    }
    ViewFlipper v_flipper;
    Button button1,button2,button3,button4,button5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flipper, container, false);
        return  view;
    }

}
