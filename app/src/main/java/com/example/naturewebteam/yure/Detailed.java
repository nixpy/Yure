package com.example.naturewebteam.yure;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class Detailed extends AppCompatActivity {

    TextView txtV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        txtV = (TextView) findViewById(R.id.detail_text);
        txtV.setText(getIntent().getStringExtra("myText"));
    }
}
