package com.example.hg;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class ProfileActivity extends AppCompatActivity {

    private BottomNavigationView btnv;
    private FrameLayout fl ;

    private HomeFragment hfg;
    private AccountFragment afg;
    private NotificationFragment nfg;
    private HistoryFragment hifg;
    private flipper flip;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnv = (BottomNavigationView)findViewById(R.id.main_nav);
        fl=(FrameLayout)findViewById(R.id.main_frame);

        hfg = new HomeFragment();
        afg = new AccountFragment();
        nfg = new NotificationFragment();
        hifg = new HistoryFragment();
        flip = new flipper();
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        tran.replace(R.id.main_frame,flip);
        tran.commit();

        btnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId())
                {
                    case R.id.nav_home:
                        if(findViewById(R.id.main_frame)!=null){
                            if(savedInstanceState!=null){
                                return false;
                            }

                            FragmentTransaction fgt = getSupportFragmentManager().beginTransaction();
                            fgt.replace(R.id.main_frame,new HomeFragment(),null ).addToBackStack(null);
                            fgt.commit();

                        }
                        return true;
                    case R.id.nav_chat:
                        if(findViewById(R.id.main_frame)!=null){
                            if(savedInstanceState!=null){
                                return false;
                            }

                            FragmentTransaction fgt = getSupportFragmentManager().beginTransaction();
                            fgt.replace(R.id.main_frame,new NotificationFragment(),null).addToBackStack(null);
                            fgt.commit();

                        }
                        return true;
                    case R.id.nav_account:
                        if(findViewById(R.id.main_frame)!=null){
                            if(savedInstanceState!=null){
                                return false;
                            }

                            FragmentTransaction fgt = getSupportFragmentManager().beginTransaction();
                            fgt.replace(R.id.main_frame,new AccountFragment(),null ).addToBackStack(null);
                            fgt.commit();

                        }
                        return true;
                    case R.id.nav_history:
                        if(findViewById(R.id.main_frame)!=null){
                            if(savedInstanceState!=null){
                                return false;
                            }

                            FragmentTransaction fgt = getSupportFragmentManager().beginTransaction();
                            fgt.replace(R.id.main_frame,new HistoryFragment(),null ).addToBackStack(null);
                            fgt.commit();

                        }
                        return true;
                    default:
                        return false;
                }

            }
        });

    }
}
