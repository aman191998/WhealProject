package com.example.hg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class main3 extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Spinner myspinner =(Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myadapter= new ArrayAdapter<String>(main3.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.City));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);
        button = (Button) findViewById(R.id.Butto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });
    }
    public void openActivity2(){
        Intent intent=new Intent(main3.this,main2.class);
        startActivity(intent);
    }

}
