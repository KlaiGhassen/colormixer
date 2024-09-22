package com.example.colormixer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText ed = findViewById(R.id.editTextText);
        CheckBox blue = findViewById(R.id.checkBox);
        CheckBox red = findViewById(R.id.checkBox2);
        CheckBox yellow = findViewById(R.id.checkBox4);
        Button mix = findViewById(R.id.button);

        mix.setOnClickListener(v -> {
            String resultmix = "";
            String selectedColors = "";

            if (blue.isChecked() && red.isChecked()) {
                resultmix = "purple";
                selectedColors = "BLUE AND RED";

            } else if (yellow.isChecked() && red.isChecked()) {
                resultmix = "orange";
                selectedColors = "YELLOW AND RED";
            } else if (blue.isChecked() && yellow.isChecked()) {
                resultmix = "green";
                selectedColors="BLUE AND YELLOW";
            } else {
                Toast.makeText(this, "chose only2 colors", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(MainActivity.this, ResponseActivity.class);
            intent.putExtra("name", ed.getText().toString());
            intent.putExtra("mix", resultmix);
            intent.putExtra("selectedColors", selectedColors);
       startActivity(intent);

        });


    }
}