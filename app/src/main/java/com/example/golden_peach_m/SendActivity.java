package com.example.golden_peach_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SendActivity extends AppCompatActivity {

    Button continue_send;
    ImageView back;
    EditText input_address, input_amount;
    String address, amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        continue_send = findViewById(R.id.continue_send);
        continue_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_address = findViewById(R.id.input_address);
                address = input_address.getText().toString();

                input_amount = findViewById(R.id.input_amount);
                amount = input_amount.getText().toString();

                if(amount.equals("") || address.equals("")){
                    Toast toast = Toast.makeText(SendActivity.this, "Incorrect input fields",
                            Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    Intent intent = new Intent(SendActivity.this, TransactionSentActivity.class);
                    startActivity(intent);
                }
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