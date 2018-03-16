package com.example.prime.mycyclewaynew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.prime.mycyclewaynew.Authentications.loginActivity;

import static java.lang.Thread.sleep;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1500);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            openLogin();
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

}
