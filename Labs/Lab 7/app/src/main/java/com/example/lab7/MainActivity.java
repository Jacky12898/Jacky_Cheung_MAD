package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generate(View view){
        Spinner phoneOS = findViewById(R.id.spinner);
        RadioGroup computerOS = findViewById(R.id.radioGroup);
        EditText name = findViewById(R.id.editText);
        Switch toastSwitch = findViewById(R.id.switch1);
        ImageView image = findViewById(R.id.imageView);
        TextView text = findViewById(R.id.textView);

        String result = name.getText().toString();

        int computerOSValue = computerOS.getCheckedRadioButtonId();
        switch (computerOSValue){
            case R.id.radioButton1:
                result += " the popular";
                break;

            case R.id.radioButton2:
                result += " the innovative";
                break;

            case R.id.radioButton3:
                result += " the open-minded";
                break;

            default:
                result += " the indecisive";
                break;
        }

        String phoneOSValue = String.valueOf(phoneOS.getSelectedItem());
        switch (phoneOSValue){
            case "Android":
                result += " techie.";
                break;

            case "iOS":
                result += " fan.";
                break;

            case "Windows":
                result += " weirdo.";
                break;

            default:
                result += " person";
                break;
        }

        image.setVisibility(View.VISIBLE);
        text.setText(result);

        if(toastSwitch.isChecked()){
            Context context = getApplicationContext();
            CharSequence message = "Cheers!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, message, duration);
            toast.show();
        }
    }
}
