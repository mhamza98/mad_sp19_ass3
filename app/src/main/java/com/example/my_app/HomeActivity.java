package com.example.my_app;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button bt, bt1 ;
    EditText useremail, userpassword;
    public int test;
    dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bt=findViewById(R.id.signup1);
        bt1=findViewById(R.id.login);
        useremail = findViewById(R.id.useremail);
        userpassword = findViewById(R.id.userpassword);

        db = new dbhelper(this);

    bt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(HomeActivity.this,signup.class);
        startActivity(it);
        }
    });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = useremail.getText().toString();
                String pass = userpassword.getText().toString();

                if (!user.isEmpty() || !pass.isEmpty()) {
                    Cursor data = db.getInfo();

                    while (data.moveToNext()) {
                        if (user.equals(data.getString(5)) && pass.equals(data.getString(6))) {
                            test = 1;
                        }
                    }

                    if (test == 1) {
                        Intent it1 = new Intent(HomeActivity.this, homescreen.class);
                        it1.putExtra("email",user);
                        startActivity(it1);
                        finish();
                    } else
                        Toast.makeText(getApplicationContext(), "Not valid", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "empty fields", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
