package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Level_1 extends AppCompatActivity {

    private CheckBox vertical;
    private CheckBox horizontal;
    private Boolean verticalValue = false;
    private Boolean horizontalValue = false;
    private int countX = 0;
    private int countY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);

        vertical = findViewById(R.id.checkBoxVertical);
        horizontal = findViewById(R.id.checkBoxHorizontal);

        if (savedInstanceState != null) {
            countX = savedInstanceState.getInt("x");
            countY = savedInstanceState.getInt("y");
            Float rotation = savedInstanceState.getFloat("rotation");
            TextView text = findViewById(R.id.text);

            float density = getResources().getDisplayMetrics().density;
            int x = (int)(10 * density);
            int y = (int)(10 * density);

            if(countX >= 0){
                for(int i = 0; i < countX; i++){
                    text.setX(text.getX() - x);
                }
            }

            else{
                for(int i = 0; i > countX; i--){
                    text.setX(text.getX() + x);
                }
            }

            if(countY >= 0){
                for(int i = 0; i < countY; i++){
                    text.setY(text.getY() - y);
                }
            }

            else{
                for(int i = 0; i > countY; i--){
                    text.setY(text.getY() + y);
                }
            }

            text.setRotation(rotation);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("x", countX);
        outState.putInt("y", countY);
        TextView text = findViewById(R.id.text);
        outState.putFloat("rotation", text.getRotation());
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

        if(verticalValue && horizontalValue){
            text.setRotation(text.getRotation() + 90);
        }

        if((text.getX() == -75) && (text.getY() == 240) && (text.getRotation() == 270)){
            Context context = getApplicationContext();
            CharSequence message = "You Win!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, message, duration);
            toast.show();
            finish();
        }
    }

    public void move(View view){
        TextView text = findViewById(R.id.text);
        float density = getResources().getDisplayMetrics().density;
        int x = (int)(10 * density);
        int y = (int)(10 * density);

        if(verticalValue && horizontalValue){
            text.setX(text.getX() - x);
            countX++;
        }

        else if(verticalValue && !horizontalValue){
            text.setY(text.getY() + y);
            countY--;
        }

        else if(!verticalValue && horizontalValue){
            text.setX(text.getX() + x);
            countX--;
        }

        else{
            text.setY(text.getY() - y);
            countY++;
        }

        if(countX == 13 && countY == 14 && (text.getRotation() == 270)){
            Context context = getApplicationContext();
            CharSequence message = "You Win!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, message, duration);
            toast.show();
            finish();
        }
    }

    public void quit(View view){
        finish();
    }
}
