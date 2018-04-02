package com.example.prime.mycyclewaynew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.prime.mycyclewaynew.Authentications.UserAccount;
import com.example.prime.mycyclewaynew.Authentications.loginActivity;
import com.example.prime.mycyclewaynew.Maps.MapsActivity;
import com.google.firebase.auth.FirebaseAuth;

import static java.lang.Thread.sleep;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (auth.getCurrentUser() != null) {
                                Toast.makeText(getApplicationContext(), "Logged in as "+auth.getCurrentUser().getEmail(), Toast.LENGTH_LONG).show();
                                openmapActivity();
                            }
                            else openLogin();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
    void openLogin(){
        Intent i = new Intent(this,loginActivity.class);
        //finish();
        startActivity(i);
    }
    void openmapActivity(){
        Intent i = new Intent(this,MapsActivity.class);
        //finish();
        startActivity(i);
    }

}
