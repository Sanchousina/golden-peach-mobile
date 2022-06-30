package com.example.golden_peach_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SendActivity extends AppCompatActivity {

    Button continue_send;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        continue_send = findViewById(R.id.continue_send);
        continue_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendActivity.this, TransactionSentActivity.class);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.logo_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendActivity.this, AssetsActivity.class);
                startActivity(intent);
            }
        });
    }
}