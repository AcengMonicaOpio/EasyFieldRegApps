package com.example.easyfieldregapps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Vibrate extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        button =  findViewById(R.id.button1);
        button.setOnClickListener(butListener);
    }
    private View.OnClickListener butListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long milliseconds = 5000;
            vib.vibrate(milliseconds);
        }
    };
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Vibrate.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
