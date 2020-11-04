package com.example.easyfieldregapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Battery(View view) {
        Intent intent=new Intent(MainActivity.this,HomebatteryActivity.class);
        startActivity(intent);
        finish();
    }


    public void Alarms(View view) {
        Intent intent=new Intent(MainActivity.this,Alarm.class);
        startActivity(intent);
        finish();
    }

    public void homeimplicit(View view) {
        Intent intent=new Intent(MainActivity.this,Homeimplicitintent.class);
        startActivity(intent);
        finish();
    }

    public void vibrate(View view) {
        Intent intent=new Intent(MainActivity.this,Vibrate.class);
        startActivity(intent);
        finish();
    }
}