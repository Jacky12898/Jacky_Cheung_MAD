package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {
    private NameClass nameClass = new NameClass();
    private String location = nameClass.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        location = intent.getStringExtra("Location");
        TextView getLocationName = findViewById(R.id.textLocation);
        getLocationName.setText(location);

        Button searchButton = findViewById(R.id.button2);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                loadLocation(view);
            }
        };
        searchButton.setOnClickListener(onclick);
    }

    private void loadLocation(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://maps.google.co.in/maps?q=" + location));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
