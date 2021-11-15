package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

            ArrayList<String> data = getIntent().getStringArrayListExtra("userData");



            TextView display1 = (TextView) findViewById(R.id.fName_text);
            TextView display2 = (TextView) findViewById(R.id.lname_text);
            TextView display3 = (TextView) findViewById(R.id.age_text);
            TextView display4 = (TextView) findViewById(R.id.dadname_text);
            TextView display5 = (TextView) findViewById(R.id.momname_text);

            display1.setText(data.get(0));
            display2.setText(data.get(1));
            display3.setText(data.get(2));
            display4.setText(data.get(3));
            display5.setText(data.get(4));

    }
}