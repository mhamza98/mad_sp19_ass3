package com.example.my_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class homescreen extends AppCompatActivity {

    Button bt2, bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
            bt2= findViewById(R.id.pi);
            bt3= findViewById(R.id.ss);


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();

                String emailuser = intent.getStringExtra("email");

                Intent it = new Intent(homescreen.this,editdetails.class);
                it.putExtra("useremail",emailuser);
                startActivity(it);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(homescreen.this,setting.class);
                startActivity(it1);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
