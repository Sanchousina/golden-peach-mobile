package com.example.golden_peach_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MetamaskActivity extends AppCompatActivity {

    CheckBox checkbox;
    Boolean check;
    Button cancel_button, next_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metamask);
        cancel_button = findViewById(R.id.cancel);
        next_button = findViewById(R.id.next_button);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkbox = findViewById(R.id.checkbox);
                check = checkbox.isChecked();

                if(!check){
                    Toast toast = Toast.makeText(MetamaskActivity.this, "Choose account",
                            Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), MetamaskNextActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}