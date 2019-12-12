package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private boolean levelOneClear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StartLevelOne(View view){
        Intent intent = new Intent(this, Level_1.class);
        startActivity(intent);
    }

    public void StartLevelTwo(View view){
        Intent intent = new Intent(this, Level_2.class);
        startActivity(intent);
    }

    public void exit(View view){
        finish();
        System.exit(0);
    }
}
