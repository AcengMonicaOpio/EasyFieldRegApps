package com.example.easyfieldregapps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomebatteryActivity extends AppCompatActivity {
    // Views
    private ImageView imageView;
    private TextView textView;
    private Button button;

    // Receiver
    private BroadcastReceiver broadcastBatteryLevels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homebattery);

        setupViews();
        setupBroadcastReceiver();

    }

    private void setupViews() {
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btnCheck);
    }

    private void setupBroadcastReceiver() {
        broadcastBatteryLevels = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Integer batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                if (batteryLevel > 90){
                    // Battery is full
                    imageView.setImageResource(R.drawable.full);
                    textView.setText("The battery level is " + batteryLevel.toString() + " (Full)");
                    Toast.makeText(context, "The battery level is " +batteryLevel.toString() + " (Full)", Toast.LENGTH_SHORT).show();
                }else{
                    if (batteryLevel > 60){
                        // Battery is Ok
                        imageView.setImageResource(R.drawable.medium);
                        textView.setText("The battery level is " + batteryLevel.toString() + " (Medium)");
                        Toast.makeText(context, "The battery level is " +batteryLevel.toString() + " (Medium)", Toast.LENGTH_SHORT).show();
                    }else{
                        if (batteryLevel > 30){
                            // Battery is Low
                            imageView.setImageResource(R.drawable.medium_low);
                            textView.setText("The battery level is " + batteryLevel.toString() + " (Medium Low)");
                            Toast.makeText(context, "The battery level is " +batteryLevel.toString() + " (Medium Low)", Toast.LENGTH_SHORT).show();
                        }else{
                            // Battery is Critical
                            imageView.setImageResource(R.drawable.low);
                            textView.setText("The battery level is " + batteryLevel.toString() + " (Low)");
                            Toast.makeText(context, "The battery level is " +batteryLevel.toString() + " (Low)", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastBatteryLevels, intentFilter);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(HomebatteryActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}