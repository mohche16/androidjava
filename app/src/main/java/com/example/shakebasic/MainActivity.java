package com.example.shakebasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView xText, yText, zText;
    private Sensor mySens;
    private SensorManager SM;
    private int imgRes;
    private ImageView firstImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        mySens = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Listener
        SM.registerListener(this, mySens, SensorManager.SENSOR_DELAY_NORMAL);

        xText = (TextView) findViewById(R.id.xText);
        yText = (TextView) findViewById(R.id.yText);
        zText = (TextView) findViewById(R.id.zText);

        firstImg = (ImageView) findViewById(R.id.firstImage);

        imgRes = getResources().getIdentifier("@drawable/smaug", null, this.getPackageName());
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        if (event.values[2] >= 11)
        {
            firstImg.setImageResource(imgRes);
        }
        else {
            firstImg.setImageResource(0);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not using atm
    }
}