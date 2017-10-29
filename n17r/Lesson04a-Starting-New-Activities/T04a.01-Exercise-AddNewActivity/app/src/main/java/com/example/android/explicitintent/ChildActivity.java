package com.example.android.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    TextView tvDispplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        tvDispplay = (TextView) findViewById(R.id.tv_display);
        Intent intent = getIntent();
        String input = intent.getStringExtra("input");
        System.out.println(input);
        tvDispplay.setText(input);
    }
}
