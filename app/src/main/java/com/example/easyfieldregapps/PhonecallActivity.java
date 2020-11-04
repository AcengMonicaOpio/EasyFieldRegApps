package com.example.easyfieldregapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PhonecallActivity extends AppCompatActivity {
    Button dialPhNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonecall);

        dialPhNumber= findViewById(R.id.callbtn);
        dialPhNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText phNumber = findViewById(R.id.callurl);
                Intent intent = new Intent();
                Uri uri = Uri.parse("tel:" + phNumber.getText().toString());
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(PhonecallActivity.this,Homeimplicitintent.class);
        startActivity(intent);
        finish();
    }
}