package com.example.cheungfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void build(View view){
        EditText name = findViewById(R.id.name);
        TextView output = findViewById(R.id.outputText);
        RadioButton radioBurrito = findViewById(R.id.radioButtonBurrito);
        RadioButton radioTaco = findViewById(R.id.radioButtonTaco);
        ToggleButton toggle = findViewById(R.id.toggleButton);
        Switch gluten = findViewById(R.id.switch1);
        Spinner location = findViewById(R.id.spinner);
        ImageView image = findViewById(R.id.imageView);

        String outputString = name.getText().toString();
        outputString += " wants a ";
        if(radioBurrito.isChecked()){
            image.setImageResource(R.drawable.burrito);
            outputString += "burrito with ";
        }

        else if(radioTaco.isChecked()){
            image.setImageResource(R.drawable.taco);
            outputString += "taco with ";
        }

        if(toggle.isChecked())
            outputString += "veggies in a ";

        else
            outputString += "meat in a ";

        if(gluten.isChecked())
            outputString += "corn tortilla ";

        else
            outputString += "flour tortilla ";

        switch (String.valueOf(location.getSelectedItem())){
            case "The Hill":
                outputString += "on The Hill!";
                break;
            case "29th Street":
                outputString += "on 29th Street!";
                break;
            case "Pearl Street":
                outputString += "on Pearl Street!";
            default:
                break;
        }

        if(!radioBurrito.isChecked() && !radioTaco.isChecked()){
            Context context = getApplicationContext();
            CharSequence message = "Select burrito or taco!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, message, duration);
            toast.show();
        }
        else{
            output.setText(outputString);
        }
    }

    public void findLocation(View view){
        Spinner location = findViewById(R.id.spinner);

        Burrito suggest = new Burrito();
        String suggestion = suggest.suggestLocation(String.valueOf(location.getSelectedItem()));

        Intent intent = new Intent(this, BurritoLocation.class);
        intent.putExtra("suggestion", suggestion);
        startActivity(intent);
    }
}
