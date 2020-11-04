package com.example.easyfieldregapps;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomecountActivity extends AppCompatActivity {
    public static final int SECOND = 1000;
    private TextView countDownText;
    private MediaPlayer airhorn;
    private int timeInMilliSeconds;
    private SeekBar timeSeekBar;
    Boolean counterIsActive = false;
    private Button startCountdownButton;
    private CountDownTimer countDownTimer;
    public void startCountDown(View view) {

        if (counterIsActive) {
            setStartCondition();
        } else {

            counterIsActive = true;
            timeSeekBar.setEnabled(false);
            startCountdownButton.setText("STOP!");

            countDownTimer = new CountDownTimer(timeInMilliSeconds, SECOND) {
                public void onTick(long milliSecondsUntilDone) {
                    updateCountDownText(milliSecondsUntilDone);
                }

                public void onFinish() {
                    Toast.makeText(HomecountActivity.this, "Time up! Time up!", Toast.LENGTH_SHORT).show();
                    updateCountDownText(0);
                    airhorn.start();
                    setStartCondition();
                }
            };
            countDownTimer.start();
        }
    }

    private void setStartCondition() {


         countDownText.setText("30");
        timeSeekBar.setProgress(30);
        timeSeekBar.setEnabled(true);
        countDownTimer.cancel();
        startCountdownButton.setText("GO!");
        counterIsActive = false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homecount);
        countDownText = findViewById(R.id.countdownTextView);
        updateCountDownText(0);
        airhorn = MediaPlayer.create(this, R.raw.airhorn);
        startCountdownButton = findViewById(R.id.startCountdownButton);

        timeSeekBar = findViewById(R.id.timeSeekBar);
        timeSeekBar.setMax(300);
        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                timeInMilliSeconds = progress * SECOND;
                updateCountDownText(timeInMilliSeconds);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void updateCountDownText(long milliSecondsUntilDone) {
        long minutes = milliSecondsUntilDone / 1000 / 60;
        long seconds = milliSecondsUntilDone / 1000 % 60;
        countDownText.setText(String.format("%02d:%02d",minutes,seconds ));
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(HomecountActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
