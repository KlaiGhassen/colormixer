package com.example.colormixer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_response);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String mixResult = intent.getStringExtra("mix");
        String selectedColors = intent.getStringExtra("selectedColors");


        TextView tv3 = findViewById(R.id.textView3);
        tv3.setText(" you choosed " + selectedColors);
        CheckBox purple = findViewById(R.id.checkBox);
        CheckBox green = findViewById(R.id.checkBox2);
        CheckBox orange = findViewById(R.id.checkBox4);

        Button mix = findViewById(R.id.button);

        mix.setOnClickListener(v -> {
            if (purple.isChecked() && mixResult.equals("purple")) {
                Intent intent1 = new Intent(ResponseActivity.this, SuccessActivity.class);
                startActivity(intent1);
            } else if (green.isChecked() && mixResult.equals("green")) {
                Intent intent1 = new Intent(ResponseActivity.this, SuccessActivity.class);
                startActivity(intent1);
            } else if (orange.isChecked() && mixResult.equals("orange")) {
                Intent intent1 = new Intent(ResponseActivity.this, SuccessActivity.class);
                startActivity(intent1);
            } else {
                Intent intent1 = new Intent(ResponseActivity.this, FailerActivity.class);
                startActivity(intent1);
            }

        });


    }
}