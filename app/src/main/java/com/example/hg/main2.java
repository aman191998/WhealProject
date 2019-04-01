package com.example.hg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class main2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerCountry,spinnerDivision;
    ArrayAdapter<String> countryArray,divisionArray;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
        //implementing OnItemSelectedListener (need to override the method)
        spinnerCountry.setOnItemSelectedListener(this);

        countryArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        countryArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCountry.setAdapter(countryArray);

        countryArray.add("BMW");
        countryArray.add("HYUNDAI");
        countryArray.add("TOYOTA");
        countryArray.add("TATA");
        countryArray.setNotifyOnChange(true);

        spinnerCountry.setSelection(0);

        spinnerDivision = (Spinner) findViewById(R.id.spinnerDivision);
        //implementing OnItemSelectedListener (need to override the method)
        spinnerDivision.setOnItemSelectedListener(this);

        divisionArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        divisionArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDivision.setAdapter(divisionArray);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //first spinner item position
        int countrySpinnerPosition = spinnerCountry.getSelectedItemPosition();
        switch (countrySpinnerPosition){
            case 0:
                //fill data for second spinner
                fillBangladeshDivision();
                break;
            case 1:
                //fill data for second spinner
                fillIndiaDivision();
                break;
            case 2:
                //fill data for second spinner
                fillUSADivision();
                break;
            case 3:
                //fill data for second spinner
                fillCanadaDivision();
                break;
        }
    }

    private void fillBangladeshDivision() {
        divisionArray.clear();
        divisionArray.add("Series 5");
        divisionArray.add("Series 3");
        divisionArray.add("X series");
        divisionArray.add("Series M");
        divisionArray.add("Series Z");
        divisionArray.notifyDataSetChanged();
    }

    private void fillIndiaDivision() {
        divisionArray.clear();
        divisionArray.add("VERNA");
        divisionArray.add("CRETA");
        divisionArray.add("i10");
        divisionArray.add("i20");
        divisionArray.notifyDataSetChanged();
    }

    private void fillUSADivision() {
        divisionArray.clear();
        divisionArray.add("FORTUNER");
        divisionArray.add("ETIOS");
        divisionArray.add("INNOVA");
        divisionArray.notifyDataSetChanged();
    }

    private void fillCanadaDivision(){
        divisionArray.clear();
        divisionArray.add("NEXON");
        divisionArray.add("TIAGO");
        divisionArray.add("HEXA");
        divisionArray.add("ZEST");
        divisionArray.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
