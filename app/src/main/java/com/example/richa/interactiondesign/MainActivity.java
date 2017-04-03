package com.example.richa.interactiondesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterCompass(View view){
        Intent intent = new Intent(this, CompassActivity.class);
        startActivity(intent);
    }

    public void enterAccelorometer(View view){
        Intent intent2 = new Intent(this, AccelerometerActivity.class);
        startActivity(intent2);
    }
}
