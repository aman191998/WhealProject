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
        int image[]={R.drawable.dentrepair,R.drawable.carrepaint,R.drawable.carpolish,R.drawable.expressservice};
        v_flipper= view.findViewById(R.id.v_flipper);

        for(int i=0;i<image.length;i++){
            flipeerImage(image[i]);
        }

        button1=view.findViewById(R.id.button1);
        button2=view.findViewById(R.id.button2);
        button3=view.findViewById(R.id.button3);
        button4=view.findViewById(R.id.button4);
        button5=view.findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),EngineService.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Auto_electric_service.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Hybridservice.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Air_conditioner_repair.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Exhaust_Services.class);
                startActivity(intent);
            }
        });





        return  view;
    }
    public void flipeerImage(int image){
        ImageView imageView=new ImageView(getContext());
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        v_flipper.setInAnimation(getContext() ,android.R.anim.slide_out_right);
    }

}
