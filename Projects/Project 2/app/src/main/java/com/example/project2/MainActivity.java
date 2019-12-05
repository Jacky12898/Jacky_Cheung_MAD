package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean levelOneClear = false;
    private boolean levelTwoClear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StartLevelOne(View view){
        Intent intent = new Intent(this, LevelOne.class);
        startActivity(intent);
    }

    public void StartLevelTwo(View view){
        Intent intent = new Intent(this, LevelTwo.class);
        startActivity(intent);
    }
}
