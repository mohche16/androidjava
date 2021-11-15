package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn, loginActivityBtn, dataActivityBtn, dataViewActivityloginBtn;
    private EditText username, password;

    public void dataInputActivity() {
        Intent intention = new Intent(this, MainActivity2.class);
        startActivity(intention);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.usnText);
        password = (EditText) findViewById(R.id.passwdText);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        loginActivityBtn = (Button) findViewById(R.id.loginActivity);
        dataActivityBtn = (Button) findViewById(R.id.dataActivity);
        dataViewActivityloginBtn = (Button) findViewById(R.id.dataViewActivity);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text_name = username.getText().toString();
                String text_pass = password.getText().toString();

                if (text_name.equals("jeff") && text_pass.equals("bezos")) {

                    Toast.makeText(MainActivity.this, "Login Success!", Toast.LENGTH_LONG).show();
                    dataInputActivity();

                } else {

                    Toast.makeText(MainActivity.this, "Incorrect details!", Toast.LENGTH_LONG).show();

                };
            };


        });

        loginActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intention = new Intent(v.getContext(), MainActivity.class);
                startActivity(intention);
            }
        });

        dataActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intention = new Intent(v.getContext(), MainActivity2.class);
                startActivity(intention);
            }
        });

        dataViewActivityloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intention = new Intent(v.getContext(), MainActivity3.class);
                startActivity(intention);
            }
        });



    }
}