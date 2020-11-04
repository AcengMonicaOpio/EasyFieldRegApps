package com.example.easyfieldregapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Homeimplicitintent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeimplicitintent);
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Homeimplicitintent.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void call(View view) {
        Intent intent=new Intent(Homeimplicitintent.this,PhonecallActivity.class);
        startActivity(intent);
        finish();
    }
    public void mail(View view) {
        Intent intent=new Intent(Homeimplicitintent.this,MailActivity.class);
        startActivity(intent);
        finish();
    }
}