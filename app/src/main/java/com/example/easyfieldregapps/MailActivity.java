package com.example.easyfieldregapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MailActivity extends AppCompatActivity {
    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        editTextTo=findViewById(R.id.editTextTo);
        editTextSubject=findViewById(R.id.editTextSubject);
        editTextMessage=findViewById(R.id.editTextMessage);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("plain/text");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent(MailActivity.this, Homeimplicitintent.class);
        startActivity(intent);
        finish();
    }
}