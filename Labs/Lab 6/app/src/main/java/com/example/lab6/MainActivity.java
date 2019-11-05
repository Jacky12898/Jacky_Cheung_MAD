package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterName(View view){
        TextView display = findViewById(R.id.display);
        EditText name = findViewById(R.id.editText);
        String nameValue = name.getText().toString();
        display.setText("Hello " + nameValue + "!");

        ImageView smile = findViewById(R.id.imageView);
        smile.setImageResource(R.drawable.smile);
    }
}
