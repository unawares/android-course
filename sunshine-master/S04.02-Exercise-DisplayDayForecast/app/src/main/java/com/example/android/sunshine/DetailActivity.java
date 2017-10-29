package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView weather_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        weather_display = (TextView) findViewById(R.id.weather_display);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        Intent intent = getIntent();
        String weather = intent.getStringExtra("weather");
        weather_display.setText(weather);
    }
}