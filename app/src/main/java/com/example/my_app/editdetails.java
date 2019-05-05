package com.example.my_app;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class editdetails extends AppCompatActivity {

    EditText name2, fname2, phone2, dob2, email2, password2, address2;
    Button editinfo;
    dbhelper db1;
    RadioGroup rg;
    RadioButton RB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdetails);
        name2=findViewById(R.id.editname);
        fname2=findViewById(R.id.editfname);
        phone2=findViewById(R.id.editphone);
        dob2=findViewById(R.id.editdob);
        email2=findViewById(R.id.editemail);
        password2=findViewById(R.id.editpassword);
        address2=findViewById(R.id.editaddress);
        editinfo=findViewById(R.id.editdetails);

        rg = findViewById(R.id.editgender);




        db1 = new dbhelper(this);
        Intent intent = getIntent();

        final String emailuser = intent.getStringExtra("useremail");

        db1 = new dbhelper(this);
        Cursor data = db1.getInfo();

        while (data.moveToNext()) {
            if (emailuser.equals(data.getString(5))) {
                name2.setText(data.getString(1));
                fname2.setText(data.getString(2));
                email2.setText(data.getString(5));
                dob2.setText(data.getString(4));
                phone2.setText(data.getString(3));
                password2.setText(data.getString(6));
                address2.setText(data.getString(7));
                if(data.getString(8).equals("Male")){
                    ((RadioButton)rg.getChildAt(0)).setChecked(true);
                }
                else
                    ((RadioButton)rg.getChildAt(1)).setChecked(true);
            }
        }



        editinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = name2.getText().toString();
                String fname = fname2.getText().toString();
                String phone = phone2.getText().toString();
                String dob = dob2.getText().toString();
                String email = email2.getText().toString();
                String password = password2.getText().toString();
                String address = address2.getText().toString();

                int genderID = rg.getCheckedRadioButtonId();

                RB = findViewById(genderID);

                boolean check = db1.insertion(name, fname, phone, dob, email, password, address,RB.getText().toString(),2);
                if (check)
                    Toast.makeText(getApplicationContext(), "Edition Success", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Edition failed", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
