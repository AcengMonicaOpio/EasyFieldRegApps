package com.example.easyfieldregapps;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Alarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Button mShowDialog =findViewById(R.id.btnShowDialog);
        mShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Alarm.this);
                View mView = getLayoutInflater().inflate(R.layout.alert_timer, null);
                final EditText time =mView.findViewById(R.id.timer);
                Button mLogin = mView.findViewById(R.id.confirm);


                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!time.getText().toString().isEmpty()){
                            Toast.makeText(Alarm.this,
                                    R.string.value_entered,
                                    Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            String s=time.getText().toString();
                            Intent i = new Intent(Alarm.this, HomecountActivity.class);
                            i.putExtra("time",s);//adding additional data using putExtras()
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(Alarm.this,
                                    R.string.error_msg,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Alarm.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
