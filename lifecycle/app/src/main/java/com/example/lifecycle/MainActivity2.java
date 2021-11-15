package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private Button sendInpBtn;
    private EditText uName, uLastName, uAge, uMName, uDName;

    public void dataViewActivity(ArrayList<String> list) {
        Intent intention = new Intent(this, MainActivity3.class);
        intention.putStringArrayListExtra("userData", list);
        startActivity(intention);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        uName = (EditText) findViewById(R.id.uName);
        uLastName = (EditText) findViewById(R.id.uLastName);
        uAge = (EditText) findViewById(R.id.uAge);
        uMName = (EditText) findViewById(R.id.uMName);
        uDName = (EditText) findViewById(R.id.uDName);
        sendInpBtn = (Button) findViewById(R.id.sendInpBtn);

        sendInpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text_fname = uName.getText().toString();
                String text_lname = uLastName.getText().toString();
                String text_age = uAge.getText().toString();
                String text_mname = uMName.getText().toString();
                String text_dname = uDName.getText().toString();

                if (text_fname.isEmpty() || text_lname.isEmpty() || text_age.isEmpty() || text_mname.isEmpty() || text_dname.isEmpty()) {

                    Toast.makeText(MainActivity2.this, "Please complete all the fields!", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(MainActivity2.this, "Data sent successfully!", Toast.LENGTH_LONG).show();

                    String textOne = uName.getText().toString();
                    String textTwo = uLastName.getText().toString();
                    String textThree = uAge.getText().toString();
                    String textFour = uMName.getText().toString();
                    String textFive = uDName.getText().toString();

                    ArrayList<String> arrayListData = new ArrayList<String>();
                    arrayListData.add(textOne);
                    arrayListData.add(textTwo);
                    arrayListData.add(textThree);
                    arrayListData.add(textFour);
                    arrayListData.add(textFive);


                    dataViewActivity(arrayListData);

                };
            };
        });
    }
}