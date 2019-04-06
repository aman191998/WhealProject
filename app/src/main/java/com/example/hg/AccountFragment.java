package com.example.hg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    Button b1;
    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_account, container, false);
        // Inflate the layout for this fragment
        b1=(Button) view.findViewById(R.id.profile);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        return  view;
    }

    public void openActivity2(){
//        Intent intent=new Intent(HistoryFragment.this.getActivity(),main3.class);
//        startActivity(intent);
    }

}
