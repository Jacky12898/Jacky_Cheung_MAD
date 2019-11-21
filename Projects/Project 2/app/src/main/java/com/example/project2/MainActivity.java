package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox vertical;
    private CheckBox horizontal;
    private Button rotate;
    private Button move;
    private Boolean verticalValue = false;
    private Boolean horizontalValue = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vertical = findViewById(R.id.checkBoxVertical);
        horizontal = findViewById(R.id.checkBoxHorizontal);
    }

    public void checkBoxes(View view){
        Boolean isVertical = vertical.isChecked();
        Boolean isHorizontal = horizontal.isChecked();

        if(isVertical){
            verticalValue = true;
        }
        else{
            verticalValue = false;
        }

        if(isHorizontal){
            horizontalValue = true;
        }
        else{
            horizontalValue = false;
        }
    }

    public void rotate(View view){
        TextView text = findViewById(R.id.text);
        text.setRotation(text.getRotation() + 90);
    }

    public void move(View view){
        TextView text = findViewById(R.id.text);

        if(verticalValue && horizontalValue){
            text.setX(text.getX() - 50);
        }

        else if(verticalValue && !horizontalValue){
            text.setY(text.getY() + 20);
        }

        else if(!verticalValue && horizontalValue){
            text.setX(text.getX() - 20);
        }

        else{
            text.setY(text.getY() - 20);
        }
    }
}
