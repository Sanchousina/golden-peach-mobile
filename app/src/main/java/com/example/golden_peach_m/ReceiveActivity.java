package com.example.golden_peach_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiveActivity extends AppCompatActivity {

    ImageView back, copy;
    TextView address;

    private ClipboardManager myClipboard;
    private ClipData myClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        copy = findViewById(R.id.copy);
        address = findViewById(R.id.address_to_copy);
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = address.getText().toString();
                myClip = ClipData.newPlainText("wallet address", s);
                myClipboard.setPrimaryClip(myClip);

                Toast.makeText(getApplicationContext(), "Text Copied",
                        Toast.LENGTH_SHORT).show();
            }
        });

        back = findViewById(R.id.logo_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceiveActivity.this, AssetsActivity.class);
                startActivity(intent);
            }
        });

        copy = findViewById(R.id.copy);

    }
}