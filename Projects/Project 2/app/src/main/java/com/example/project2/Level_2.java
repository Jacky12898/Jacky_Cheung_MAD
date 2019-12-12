package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Level_2 extends AppCompatActivity {

    public TextView locationName;
    public TextView moveText;
    public EditText north;
    public EditText west;
    public Switch mapSwitch;
    private Boolean locationVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_2);
        locationName = findViewById(R.id.locationName);
        locationName.setVisibility(View.INVISIBLE);
        locationVisible = false;
        if (savedInstanceState != null) {
            locationVisible = savedInstanceState.getBoolean("visible");
            if(locationVisible){
                locationName.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("visible", locationVisible);
    }


    public void move(View view){
        float density = getResources().getDisplayMetrics().density;
        mapSwitch = findViewById(R.id.mapSwitch);
        if(!mapSwitch.isChecked()){
            moveText = findViewById(R.id.text);
            west = findViewById(R.id.westText);
            north = findViewById(R.id.northText);
            String westText = west.getText().toString();
            String northText = north.getText().toString();

            if(westText.length() > 0 && northText.length() > 0){
                int x = (int)(Float.parseFloat(westText) * density);
                int y = (int)(Float.parseFloat(northText) * density);
                moveText.setX(x);
                moveText.setY(y);

                if(Integer.parseInt(westText) == 105 && Integer.parseInt(northText) == 40){
                    Context context = getApplicationContext();
                    CharSequence message = "You Win!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();
                    finish();
                }
            }
        }

        else{
            locationName.setVisibility(View.VISIBLE);
            locationVisible = true;
        }
    }

    public void map(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://maps.google.co.in/maps?q="));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void quit(View view){
        finish();
    }
}
