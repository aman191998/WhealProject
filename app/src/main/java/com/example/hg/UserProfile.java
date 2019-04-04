package com.example.hg;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {

    ImageView img;
    static  int PReqCode=1;
    static int REQUESCODE=1;
    Uri pickedImgUri;
    private Button button;
    private EditText name,emailid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        final Spinner myspinner =(Spinner) findViewById(R.id.spinner);
        name=(EditText) findViewById(R.id.name);
        emailid=(EditText) findViewById(R.id.email);


        ArrayAdapter<String> myadapter= new ArrayAdapter<String>(UserProfile.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.City));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);

        img=(ImageView) findViewById(R.id.userimage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT>=22){
                    checkAndRequestForPermission();
                }
                else{
                    openGallery();
                }
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                openActivity2();

            }
        });

    }

    private void openActivity2() {
        Intent intent=new Intent(UserProfile.this,main2.class);
        startActivity(intent);
    }


    private void openGallery() {

        Intent galleryIntent=new Intent(Intent.ACTION_GET_CONTENT);
       galleryIntent.setType("image/*");
       startActivityForResult(galleryIntent,REQUESCODE);
    }



    private void checkAndRequestForPermission() {

        if(ContextCompat.checkSelfPermission(UserProfile.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(UserProfile.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast.makeText(UserProfile.this, "Please accept for require permission ", Toast.LENGTH_SHORT).show();
            }
            else {
                ActivityCompat.requestPermissions(UserProfile.this,new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        PReqCode);
            }



        }
        else{
            openGallery();
        }



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        pickedImgUri=data.getData();
        img.setImageURI(pickedImgUri);
    }
}
