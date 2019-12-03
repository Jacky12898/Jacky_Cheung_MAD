package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NameClass nameClass = new NameClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterButton = findViewById(R.id.button);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                enterLocation(view);
            }
        };
        enterButton.setOnClickListener(onclick);
    }

    private void enterLocation(View view){
        EditText getLocation = findViewById(R.id.editText);
        String location = getLocation.getText().toString();

        nameClass.setName(location);
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("Location", location);
        startActivity(intent);
    }
}