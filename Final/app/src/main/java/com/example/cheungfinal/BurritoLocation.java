package com.example.cheungfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BurritoLocation extends AppCompatActivity {

    public String suggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burrito_location);

        Intent intent = getIntent();
        suggestion = intent.getStringExtra("suggestion");

        TextView text = findViewById(R.id.locationText);
        text.setText("I suggest checking out: " + suggestion);
    }

    public void map(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://maps.google.co.in/maps?q=" + suggestion));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void website(View view){
        String website = "";
        switch (suggestion){
            case "Illegal Petes":
                website = "http://illegalpetes.com/";
                break;
            case "Chipotle":
                website = "https://www.chipotle.com/";
                break;
            case "Bartaco":
                website = "https://bartaco.com/";
                break;
            default:
                break;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(website));
        startActivity(intent);
    }
}
