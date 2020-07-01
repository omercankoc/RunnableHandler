package com.omercankoc.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RunnableHandler extends AppCompatActivity {

    TextView textViewRunnableHandler;
    Button buttonStart;
    Button buttonStop;

    int number;
    Runnable runnable;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runnable_handler);

        textViewRunnableHandler = findViewById(R.id.textViewRunnableHaandler);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);

        int number = 1;
    }

    public void onClickStart(View v) {

        handler = new Handler();
        runnable = new Runnable() {

            @Override
            public void run() {
                textViewRunnableHandler.setText("Time : " + number);
                number++;
                handler.postDelayed(runnable,1000);
                // 1000 : Her saniye tekrarla.
            }
        };
        handler.post(runnable);
        buttonStart.setEnabled(false);
    }

    public void onClickStop(View v){
        buttonStart.setEnabled(true);
        handler.removeCallbacks(runnable);
        number = 0;
        textViewRunnableHandler.setText("Time : " + number);
    }
}