package com.example.my_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText name1, fname1, phone1, dob1, email1, password1, address1;
    Button signup1;
    dbhelper db;

    RadioGroup rg;
    RadioButton RB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name1 = findViewById(R.id.name);
        fname1 = findViewById(R.id.fname);
        phone1 = findViewById(R.id.phone);
        dob1 = findViewById(R.id.dob);
        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        address1 = findViewById(R.id.address);
        signup1 = findViewById(R.id.signup);

        rg = findViewById(R.id.gender);

        int genderID = rg.getCheckedRadioButtonId();

        RB = findViewById(genderID);


        db = new dbhelper(this);

        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name1.getText().toString();
                String fname = fname1.getText().toString();
                String phone = phone1.getText().toString();
                String dob = dob1.getText().toString();
                String email = email1.getText().toString();
                String password = password1.getText().toString();
                String address = address1.getText().toString();

                if (!name.isEmpty() && !fname.isEmpty() && !phone.isEmpty() && !dob.isEmpty() && !email.isEmpty() && !password.isEmpty() && !address.isEmpty()) {
                    boolean check = db.insertion(name, fname, phone, dob, email, password, address,RB.getText().toString(), 1);

                    if (check) {
                        Toast.makeText(getApplicationContext(), "Insertion Success", Toast.LENGTH_SHORT).show();
                        Intent it3 = new Intent(signup.this, HomeActivity.class);
                        startActivity(it3);
                        finish();
                    } else
                        Toast.makeText(getApplicationContext(), "Insertion failed", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
