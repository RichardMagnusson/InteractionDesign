package com.example.richa.interactiondesign;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener  {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private Sensor mAccelerometer;
    private float[] accelerometerValue = new float[3];
    String xAxis;
    String yAxis;
    String zAxis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this, mAccelerometer);
    }

    public void onSensorChanged(SensorEvent event) {
        if (event.sensor == mAccelerometer) {
            accelerometerValue = event.values;
        }
        xAxis = String.valueOf(accelerometerValue[0]);
        TextView textViewX = (TextView) findViewById(R.id.xView);
        textViewX.setText(xAxis);

        yAxis = String.valueOf(accelerometerValue[1]);
        TextView textViewY = (TextView) findViewById(R.id.yView);
        textViewY.setText(yAxis);

        zAxis = String.valueOf(accelerometerValue[2]);
        TextView textViewZ = (TextView) findViewById(R.id.zView);
        textViewZ.setText(zAxis);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //TODO Auto-generated method stub
    }
}
