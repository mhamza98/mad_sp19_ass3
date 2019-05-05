package com.example.my_app;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class setting extends AppCompatActivity {

    SharedPreferences sh;

    Switch s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        sh = getPreferences(MODE_PRIVATE);
        s1 = findViewById(R.id.mode);
        s2 = findViewById(R.id.sms);
        s3 = findViewById(R.id.remainder);
        s4 = findViewById(R.id.notification);


        s1.setChecked( sh.getBoolean("mode" ,false));
        s2.setChecked( sh.getBoolean("sms" ,false));
        s3.setChecked( sh.getBoolean("remainder" ,false));
        s4.setChecked( sh.getBoolean("notify" ,false));

    }

    public void settingSave(View view) {
        SharedPreferences.Editor edt = sh.edit();

        edt.putBoolean("mode" ,s1.isChecked());
        edt.putBoolean("sms" ,s2.isChecked());
        edt.putBoolean("remainder" ,s3.isChecked());
        edt.putBoolean("notify" ,s4.isChecked());
        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

        edt.apply();
        edt.commit();

        finish();
    }
}
