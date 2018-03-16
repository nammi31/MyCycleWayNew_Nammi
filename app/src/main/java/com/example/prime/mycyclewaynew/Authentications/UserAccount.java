package com.example.prime.mycyclewaynew.Authentications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.prime.mycyclewaynew.R;

public class UserAccount extends AppCompatActivity {

    Button editbtn;
    EditText username,password,confpass,emailaddress;
    ImageView imgview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
    }
}
